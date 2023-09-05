package com.example.jspservletjdbc.dao;

import com.example.jspservletjdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/db_test";
    private String username = "root";
    private String password = "Davy2018";

    private static final String INSERT_USERS_SQL = "insert into users"
            + " (name, email, country) values "
            + " (?,?,?);";

    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";

    /**
     * 通过 DriverManager，建立连接 connection
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcURL, username, password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return connection;
    }

    /**
     * Insert  SQL
     */

    public void insertUser(User user) {

        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * Update
     */
    public void updateUser(User user){
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.setInt(4,user.getId());
            boolean rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Select
     */
    public User selectUser(int id){
        User user = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("name");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;


    }

    /**
     * Select All
     */
    public List<User> selectAllUsers(){
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);

            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("name");
                String country = resultSet.getString("country");

                users.add(new User(name, email, country));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;


    }
}

