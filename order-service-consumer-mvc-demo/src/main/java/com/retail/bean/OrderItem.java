package com.retail.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String productId;
	private int quantity;
	private double productPrice;
	public OrderItem() {
	}
	public OrderItem(long id, String productId, int quantity, double productPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	
	public OrderItem(String productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public OrderItem(String productId, int quantity, double productPrice) {
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
