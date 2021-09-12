package com.retail.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.bean.ProductList;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CatalogProdcutsService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="catalogproducts", fallbackMethod = "getAllProductsFallback")
	public ProductList getAllProducts() {
		ProductList products=restTemplate.getForObject("http://catalog-service/products/", ProductList.class);
		return products;
	}
	
	public ProductList getAllProductsFallback() {
		return new ProductList(null);
	}
}
