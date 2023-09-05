package com.example.myorderservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * JPA
 * 包含 List 集合的类
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    //cascade属性表明操作是否从父对象级联到被关联的对象
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
