package com.order.service;

import com.order.bean.OrderT1;
import com.order.customexceptions.InsufficientStockException;
import com.order.customexceptions.NegativeQuantityException;
import com.order.customexceptions.OrderIdNotFoundException;

public interface OrderService {

	OrderT1 createOrder(OrderT1 order) throws NegativeQuantityException, InsufficientStockException;
	OrderT1 findOrderById(long id) throws OrderIdNotFoundException;
}
