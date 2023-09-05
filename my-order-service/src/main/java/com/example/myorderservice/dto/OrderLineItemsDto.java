package com.example.myorderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTOs normally are created as POJOs
 * DTO stands for Data Transfer Object, which is a design pattern.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {

    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
