package com.retail.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.bean.OrderT;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="order", fallbackMethod = "createOrderFallback")
	public OrderT createOrder(OrderT order) {
		OrderT o=restTemplate.postForObject("http://order-service/orders", order, OrderT.class);
		return o;
	}
	
	public OrderT createOrderFallback(OrderT order,Exception e) {
		return new OrderT(null, null, null);
	}
	
}
