package com.example.myinventoryservice;

import com.example.myinventoryservice.model.Inventory;
import com.example.myinventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 *  CommandLineRunner 作用
 *  在spring boot应用中，我们可以在程序启动之前执行任何任务。为了达到这个目的，
 *  使用CommandLineRunner或ApplicationRunner接口创建bean，spring boot会自动监测到它们,
 *  CommandLineRunner和ApplicationRunner的作用是在程序开始运行前执行任务或记录信息。
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient // EurekaClient
public class MyInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyInventoryServiceApplication.class, args);
	}

	/**
	 * 用于初始化数据到数据库
	 * CommandLineRunner和ApplicationRunner的作用是在程序开始运行前执行任务或记录信息。
	 * @ Bean, Spring 会加载
	 */
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {

			Inventory inventory = new Inventory();
			inventory.setSkuCode("Iphone 13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Iphone 13 Pro Max");
			inventory1.setQuantity(0);

//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);

		};
	}
}
