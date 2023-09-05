package com.example.myinventoryservice.controller;


import com.example.myinventoryservice.dto.InventoryResponse;
import com.example.myinventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    // 称为： endpoint
    //@GetMapping("/{sku-code}")
    // 更换请求参数类型：http://localhost:8082/api/inventory?skuCode=iphone13&skuCode=iphone14
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        log.info("RequestParam skuCode: "+skuCode);

       return inventoryService.isInStock(skuCode);
    }
}
