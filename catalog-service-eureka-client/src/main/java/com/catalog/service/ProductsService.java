package com.catalog.service;

import java.util.List;
import java.util.Optional;

import com.catalog.bean.ProductList;
import com.catalog.bean.Products;

public interface ProductsService {

	public ProductList getAllProducts();
	public Optional<Products> getProductByCode(String code);
	public double getProductPriceByProductCode(String code);
}
