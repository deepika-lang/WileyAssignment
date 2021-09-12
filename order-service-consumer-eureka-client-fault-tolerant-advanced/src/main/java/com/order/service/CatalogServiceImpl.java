package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.bean.Products;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="catalog",fallbackMethod = "getProductsByProductCodeFallback")
	public Products getProductByProductCode(String code) {
		Products product = restTemplate.getForObject("http://catalog-service/products/" + code,Products.class);
		return product;
	}
	
	public Products getProductsByProductCodeFallback(String code,Exception e) {
		Products p=new Products(0,null,null,null,0);
		return p;
	}

}
