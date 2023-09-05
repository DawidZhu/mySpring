package com.example.myorderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 *  OrderRequest 是一个List类型
 */
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
