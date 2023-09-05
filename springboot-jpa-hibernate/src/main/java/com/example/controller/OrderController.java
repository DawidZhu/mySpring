package com.example.controller;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * RestController return : Json (Object or String )
 * 结合： RequestMapping，GetMapping， PostMapping
 *
 * 1. Autowired
 *  自动导入依赖的bean对象，默认时按照byType方式导入对象，
 *  Qualifier("") 必须配合Autowired 使用，获取指定名称的bean
 *  一层一层的根据依赖导入bean
 *
 *  2.Resource
 *  可添加name,指定 具体的service，用于有多个实现的接口
 *  Resource = Autowired + Qualifier
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerRepository.save(orderRequest.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getJoinInfor")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

    @GetMapping("/getCustomerByName/{name}")
    public Optional<Customer> getCustomerByName(@PathVariable("name") String name){

        log.info("getCustomerByName >>>>" + name);
        return customerRepository.findCustomerByName(name);
    }

    @GetMapping("/getByName/{name}")
    public Optional<Customer> getByName(@PathVariable("name") String name){

        log.info("getByName >>>>" + name);
        return customerRepository.getByName(name);
    }

    /**
     * PostMapping() 不可使用url 传值
     * 使用body , RequestBody
     */
    @PostMapping("/updateByName")
    public int updateByName(@RequestBody Customer customer){

        log.info("updateByName ? , email: ?  >>>>" + customer.getName() + customer.getEmail());
        return customerRepository.updateCustomerByName(customer.getName(),customer.getEmail());
    }

}
