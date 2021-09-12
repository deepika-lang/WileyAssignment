package com.order.customexceptions;

public class OrderIdNotFoundException extends Exception{

	public OrderIdNotFoundException() {
		super("Order id couldn't be found!");
	}
}
