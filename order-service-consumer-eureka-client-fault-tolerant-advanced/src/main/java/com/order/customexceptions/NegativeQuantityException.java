package com.order.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NegativeQuantityException extends Exception{

	public NegativeQuantityException() {
		super("Order quatity can not be negative");
	}
}
