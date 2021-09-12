package com.catalog.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.catalog.bean.Products;

public class ProductsRowMapper implements RowMapper<Products>{

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products product =new Products();
		product.setId(rs.getInt("id"));
		product.setCode(rs.getString("code"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getDouble("price"));
		return product;
	}

}
