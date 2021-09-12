package com.deepika.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inventory.bean.InventoryItem;
import com.inventory.service.InventoryService;

@SpringBootApplication(scanBasePackages = "com.inventory")
@EnableJpaRepositories(basePackages = "com.inventory.persistence")
@EntityScan(basePackages = "com.inventory.bean")
@EnableEurekaClient
public class InventoryServiceEurekaClientApplication implements CommandLineRunner{

	@Autowired
	private InventoryService inventoryService;
	public static void main(String[] args){
		SpringApplication.run(InventoryServiceEurekaClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inventoryService.insertInventoryItem(new InventoryItem(201,"PRO1",20));
		inventoryService.insertInventoryItem(new InventoryItem(202,"PRO2",90));
		inventoryService.insertInventoryItem(new InventoryItem(203,"PRO3",10));
		inventoryService.insertInventoryItem(new InventoryItem(204,"PRO4",25));
		
	}

}
