package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.bean.InventoryItem;
import com.inventory.persistence.InventoryDao;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryDao inventoryDao;

	@Override
	public InventoryItem findInventoryProductByCode(String productCode) {
		return inventoryDao.getInventoryItemByProductCode(productCode);
	}

	@Override
	public List<InventoryItem> getInventory() {
		return inventoryDao.findAll();
	}

	@Override
	public InventoryItem insertInventoryItem(InventoryItem inventoryItem) {
		InventoryItem item=inventoryDao.save(inventoryItem);
		return item;
	}
	
}
