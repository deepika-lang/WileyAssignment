package com.order.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientStockException extends Exception {

	public InsufficientStockException() {
		super("Order quantity exceeds the Available quantity");
	}
	
	
}
