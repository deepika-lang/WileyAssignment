package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.bean.ProductList;
import com.catalog.bean.Products;
import com.catalog.persistence.ProductsDao;

@Service
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	ProductsDao productsDao;
	@Override
	public ProductList getAllProducts() {
		ProductList productList = new ProductList(productsDao.getAllProducts()); 
		return productList;
	}

	@Override
	public Optional<Products> getProductByCode(String code){
		return productsDao.getProductByCode(code);
	}

	@Override
	public double getProductPriceByProductCode(String code) {
		return productsDao.getProductPriceByProductCode(code);
	}
	
}
