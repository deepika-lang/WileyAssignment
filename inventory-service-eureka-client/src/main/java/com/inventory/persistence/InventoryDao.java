package com.inventory.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.bean.InventoryItem;

@Repository
public interface InventoryDao extends JpaRepository<InventoryItem, Long>{

	@Transactional
	@Query("FROM InventoryItem WHERE productCode=:code")
	public InventoryItem getInventoryItemByProductCode(@Param("code")String code);
}
