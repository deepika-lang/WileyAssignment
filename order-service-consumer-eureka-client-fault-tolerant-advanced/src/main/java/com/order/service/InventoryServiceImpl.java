package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.bean.InventoryItem;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="inventory",fallbackMethod = "getInventoryByProductCodeFallback")
	public InventoryItem getInventoryByProductCode(String code) {
		InventoryItem inventoryItem = restTemplate.getForObject("http://inventory-service/inventories/" + code, InventoryItem.class);
		return inventoryItem;
	}
	
	
	public InventoryItem getInventoryByProductCodeFallback(String code,Exception e) {
		InventoryItem i=new InventoryItem(0,null,0);
		return i;
	}
}
