package com.inventory.service;

import java.util.List;

import com.inventory.bean.InventoryItem;

public interface InventoryService {

	InventoryItem findInventoryProductByCode(String productCode);
	List<InventoryItem> getInventory();
	InventoryItem insertInventoryItem(InventoryItem inventoryItem);
}
