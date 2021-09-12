package com.inventory.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.bean.InventoryItem;
import com.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventories")
public class InventoryItemRestController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping(produces="Application/json")
	public ResponseEntity<List<InventoryItem>> getInventory(){
		try {
			inventoryService.getInventory();
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventory());
	}
	
	@RequestMapping(path="/{code}",method=RequestMethod.GET,produces="Application/json")
	public ResponseEntity<InventoryItem> findInventoryItemByProductCode(@PathVariable("code")String productCode) {
		InventoryItem i=null;
		try {
		i=inventoryService.findInventoryProductByCode(productCode);
		i.getId();
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(i);
	}
}
