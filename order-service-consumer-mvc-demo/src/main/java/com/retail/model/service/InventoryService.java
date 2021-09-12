package com.retail.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.bean.InventoryItem;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class InventoryService {

	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="inventory", fallbackMethod = "getInventoryByCodeFallback")
	public InventoryItem getInventoryByCode(String code) {
		InventoryItem inventory=restTemplate.getForObject("http://inventory-service/inventories/"+code, InventoryItem.class);
		return inventory;
	}
	
	public InventoryItem getInventoryByCodeFallback(String code,Exception e) {
		return new InventoryItem(0,null,0);
	}
}
