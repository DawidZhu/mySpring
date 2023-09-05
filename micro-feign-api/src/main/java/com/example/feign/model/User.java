package com.example.feign.model;

import lombok.Data;

/**
 * 抽取到 Feign API 中
 */
@Data
public class User {
    private Long id;
    private String username;
    private String address;
}