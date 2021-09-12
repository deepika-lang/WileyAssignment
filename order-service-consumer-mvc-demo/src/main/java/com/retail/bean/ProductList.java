package com.retail.bean;

import java.util.List;


public class ProductList {
	private List<Products> products;

	
	public ProductList() {}
	
	public ProductList(List<Products> products) {
		this.products = products;
	}
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

}
