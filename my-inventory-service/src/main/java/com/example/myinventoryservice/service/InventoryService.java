package com.example.myinventoryservice.service;

import com.example.myinventoryservice.dto.InventoryResponse;
import com.example.myinventoryservice.model.Inventory;
import com.example.myinventoryservice.repository.InventoryRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    //声明式 事务
    @Transactional(readOnly = true)
    @SneakyThrows //将当前方法抛出的异常，包装成RuntimeException，骗过编译器，使得调用点可以不用显示处理异常信息。
    public List<InventoryResponse> isInStock(List<String> skuCode){
        log.info("Wait Started.");
       //  Thread.sleep(10000); 测试CircuitBreaker使用
        log.info("Wait Ended.");
       // return inventoryRepository.findBySkuCode().isPresent();
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                // inventory 分装到 InventoryResponse，使用 builder
                //map(Function<? super T, ? extends R> mapper)
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).collect(Collectors.toList());
    }
}
