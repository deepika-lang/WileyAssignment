package com.catalog.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.catalog.bean.Products;
import com.catalog.helper.ProductsRowMapper;

@Repository
public class ProductsDaoImpl implements ProductsDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Products> getAllProducts() {
		
		List<Products> products=jdbcTemplate.query("SELECT * FROM products", new ProductsRowMapper());
		return products;
	
	
	}

	@Override
	public Optional<Products> getProductByCode(String code)throws ArrayIndexOutOfBoundsException,IndexOutOfBoundsException{
		String query="select * from products where code=?";
		List<Products> p=jdbcTemplate.query(query, new ProductsRowMapper(),code);
		return Optional.ofNullable(p.get(0));
		
		
		
	}

	@Override
	public double getProductPriceByProductCode(String code) {
		Products product=jdbcTemplate.queryForObject("SELECT price FROM Products where code=?", new ProductsRowMapper(),code);
		return product.getPrice();
	}

	
	
}
