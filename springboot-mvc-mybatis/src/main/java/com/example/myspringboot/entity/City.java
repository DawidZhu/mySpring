package com.example.myspringboot.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * MyBatis 注解模式  & MyBatis-plus
 *
 * CREATE TABLE city
 *         (
 *         id      INT(11) PRIMARY KEY auto_increment,
 *         name    VARCHAR(30),
 *         state   VARCHAR(30),
 *         country VARCHAR(30)
 *         );
 *
 */
@Data //get,set
@TableName("city") //MyBatis-plus 默认会去找与类名一样的表名
public class City {
    /**
     * 所有属性都应该在数据库中
     */
    @TableField(exist = false)
    private String str;

    private Long id;
    private String name;
    private String state;
    private String country;
}
