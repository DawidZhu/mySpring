package com.example.mydesignpattern.CreationalPattern.builder;

import lombok.Data;

/**
 * Bean POJO
 * 产品类(Product):要创建的复杂对象
 */
@Data
public class Bike {
    private String frame;
    private String seat;

    public Bike() {
    }

    public Bike(String frame, String seat) {
        this.frame = frame;
        this.seat = seat;
    }
}
