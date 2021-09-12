package com.order.service;

import com.order.bean.InventoryItem;

public interface InventoryService {

	InventoryItem getInventoryByProductCode(String code);
}
