package com.catalog.persistence;

import java.util.List;
import java.util.Optional;

import com.catalog.bean.Products;

public interface ProductsDao {

	public List<Products> getAllProducts();
	public Optional<Products> getProductByCode(String code)throws ArrayIndexOutOfBoundsException,IndexOutOfBoundsException;
	public double getProductPriceByProductCode(String code);
}
