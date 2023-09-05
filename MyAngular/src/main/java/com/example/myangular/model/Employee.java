package com.example.myangular.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  JPA , model & ORMaping
 *
 *  Hibernate: create table employee (id bigint not null, email varchar(255), employee_code varchar(255) not null,
 *  image_url varchar(255), job_title varchar(255), name varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
 */
@Data
//indicating that it is a JPA entity.this entity is mapped to a table named Employee
@Entity //JPA ,ORmaping,
public class Employee implements Serializable {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //自动生成,ID should be generated automatically.
    @Column(nullable = false, updatable = false) //不能为空，不能修改
    private Long id;
    private String name;
    private String email;
    private String jobTitle;

    private String phone;
    private String imageUrl;
    @Column(nullable = false, updatable = false) //不能为空，不能修改
    private String employeeCode;

    public Employee() {
    }

    public Employee(Long id, String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }


}
