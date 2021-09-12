package com.retail.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table
public class OrderT {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String customerEmail;
	private String customerAddress;
	@OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL)
	private List<OrderItem> items;
	public OrderT() {
	}
	public OrderT(long id, String customerEmail, String customerAddress, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.items = items;
	}
	
	public OrderT(String customerEmail, String customerAddress, List<OrderItem> items) {
		super();
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.items = items;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
}
