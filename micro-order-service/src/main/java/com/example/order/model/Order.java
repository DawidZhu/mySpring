package com.example.order.model;

import com.example.feign.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通过引入Feign的API解决, Feign-api作为依赖引入， USER 找不到的问题
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}