package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.bean.OrderItem1;
import com.order.persistence.OrderDao;
import com.order.persistence.OrderItemDao;

@Service
public class OrderItemServiceimpl implements OrderItemService{
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Override
	public OrderItem1 insertOrderItem(OrderItem1 orderItem) {
		// TODO Auto-generated method stub
		return orderItemDao.save(orderItem);
	}

}
