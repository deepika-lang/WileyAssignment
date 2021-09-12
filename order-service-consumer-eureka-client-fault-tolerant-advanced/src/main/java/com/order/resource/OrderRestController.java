package com.order.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.bean.OrderT1;
import com.order.customexceptions.InsufficientStockException;
import com.order.customexceptions.NegativeQuantityException;
import com.order.customexceptions.OrderIdNotFoundException;
import com.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;
	
	@PostMapping(produces="Application/json",consumes="Application/json")
	public ResponseEntity<OrderT1> createOrder(@RequestBody OrderT1 order) {
		try {
			orderService.createOrder(order);
			return ResponseEntity.status(HttpStatus.OK).body(orderService.createOrder(order));
		}
		catch(InsufficientStockException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		catch(NegativeQuantityException e){
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);

		}
	}
	
	@GetMapping(path="/{id}",produces="Application/json")
	public ResponseEntity<OrderT1> findOrderById(@PathVariable("id") long id) {
		try {
			orderService.findOrderById(id);
			return ResponseEntity.status(HttpStatus.OK).body(orderService.findOrderById(id));
		}
		catch(OrderIdNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
