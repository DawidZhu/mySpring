package com.example.myorderservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ Table（可选）
 * name属性：指定表名，不指定时默认按驼峰命名法拆分将类名，并以下划线连接
 *
 *
 */
@Entity
@Table(name = "t_order_line_items ")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
