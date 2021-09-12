package com.order.service;

import com.order.bean.Products;

public interface CatalogService {

	Products getProductByProductCode(String code);
}
