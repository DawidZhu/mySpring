package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class OrderResponse {

    public OrderResponse(String name, String productName) {
        this.name = name;
        this.productName = productName;
    }

    private String name;
    private String productName;

}
