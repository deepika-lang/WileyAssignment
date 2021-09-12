package com.retail.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.bean.Products;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CatalogProductService {

	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="catalogproduct",fallbackMethod = "getProductByCodeFallback")
	public Products getProductByCode(String code) {
		Products product=restTemplate.getForObject("http://catalog-service/products/"+code, Products.class);
		return product;
	}
	
	public Products getProductByCodeFallback(String code,Exception e) {
		return new Products(0, null, null, null, 0);
	}
}
