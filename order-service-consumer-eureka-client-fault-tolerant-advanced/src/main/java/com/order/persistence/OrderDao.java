package com.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.bean.OrderT1;

@Repository
public interface OrderDao extends JpaRepository<OrderT1, Long>{
	
	public OrderT1 findOrderById(long id);
}
