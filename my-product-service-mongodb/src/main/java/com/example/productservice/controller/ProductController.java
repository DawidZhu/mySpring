package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * http://127.0.0.1:8086/api/product
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired //   非接口也可以注入
    ProductService productService;
    // private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //设置返回状态，201
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) //设置返回状态，200
    public List<ProductResponse> getAllProducts(){

        //测试JPA 的强大功能，按照Spring Data JPA提供的方法命名规则定义方法的名称，就可以完成查询
        productService.findProductByName("Iphone 13");
        return productService.getAllProducts();
    }
}
