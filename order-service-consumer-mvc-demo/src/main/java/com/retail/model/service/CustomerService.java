package com.retail.model.service;

import com.retail.bean.Customer;

public interface CustomerService {

	Customer getCustomer(String name,String password);
	boolean insertCustomer(Customer customer);
	boolean getCustomerByCustomerName(String name,String password);
}
