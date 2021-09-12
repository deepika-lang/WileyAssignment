package com.retail.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table
public class InventoryItem {
	@Id
	private long id;
	private String productCode;
	private int productQuantity;
	
	public InventoryItem() {
	}
	public InventoryItem(long id, String productCode, int productQuantity) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productQuantity = productQuantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
}
