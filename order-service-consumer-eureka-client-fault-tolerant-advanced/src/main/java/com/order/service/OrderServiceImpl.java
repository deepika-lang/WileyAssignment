package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.bean.InventoryItem;
import com.order.bean.OrderItem1;
import com.order.bean.OrderT1;
import com.order.bean.Products;
import com.order.customexceptions.InsufficientStockException;
import com.order.customexceptions.NegativeQuantityException;
import com.order.customexceptions.OrderIdNotFoundException;
import com.order.persistence.OrderDao;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	CatalogService catalogService;
	@Override
	public OrderT1 createOrder(OrderT1 order)throws NegativeQuantityException,InsufficientStockException {
		List<OrderItem1> orderItems =  order.getItems();

		for (OrderItem1 orderItem : orderItems) {
			if (orderItem.getQuantity() < 1) {
				throw new NegativeQuantityException();
			}
			InventoryItem inventoryItem = inventoryService.getInventoryByProductCode(orderItem.getProductId());
			if (inventoryItem.getProductQuantity() < orderItem.getQuantity()) {
				throw new InsufficientStockException();
			}
			Products product = catalogService.getProductByProductCode(orderItem.getProductId());
			orderItem.setProductPrice(product.getPrice());
		}

		return orderDao.save(order);
	}

	@Override
	public OrderT1 findOrderById(long id) throws OrderIdNotFoundException {
		OrderT1 o=orderDao.findOrderById(id);
		if(o!=null)
			return o;
		else
			throw new OrderIdNotFoundException();
	}
	
	

}
