package com.example.myinventoryservice.repository;

import com.example.myinventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // 自定义的方法，不需要实现？因为JPA根据方法名称实现了各种By方法
    // Optional<Inventory> findBySkuCode();

    // Optional<Inventory> findById(String skuCode);
    List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
