package com.retail.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.retail.bean.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {

	@Query("from Customer where customerName=:name and customerPassword=:password")
	Customer getCustomerByNamePassword(@Param("name")String name,@Param("password")String password);
}
