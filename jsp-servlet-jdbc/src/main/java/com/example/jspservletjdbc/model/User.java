package com.example.jspservletjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1:使用SHOW语句找出在服务器上当前存在什么数据库：
 * mysql> SHOW DATABASES;
 * 2:2、创建一个数据库MYSQLDATA
 * mysql> CREATE DATABASE MYSQLDATA;
 * 3:选择你所创建的数据库
 * mysql> USE MYSQLDATA; (按回车键出现Database changed 时说明操作成功！)
 * 4:查看现在的数据库中存在什么表
 * mysql> SHOW TABLES;
 * 5:创建一个数据库表
 * mysql> CREATE TABLE MYTABLE (name VARCHAR(20), sex CHAR(1));
 * 6:显示表的结构：
 * mysql> DESCRIBE MYTABLE;
 * 7:往表中加入记录
 * mysql> insert into MYTABLE values ("hyq","M");
 */
@Data

public class User {
    private int id;
    private String name;
    private String email;
    private String country;

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(int id, String name, String email, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }
}
