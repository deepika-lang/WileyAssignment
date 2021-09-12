package com.order.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderItem1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String productId;
	private int quantity;
	private double productPrice;
	public OrderItem1() {
	}
	public OrderItem1(long id, String productId, int quantity, double productPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	
	public OrderItem1(String productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public OrderItem1(String productId, int quantity, double productPrice) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}
