package com.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.bean.OrderItem1;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItem1, Long> {
	
}
