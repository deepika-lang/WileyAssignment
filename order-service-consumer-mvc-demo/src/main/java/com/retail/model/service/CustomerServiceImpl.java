package com.retail.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.bean.Customer;
import com.retail.model.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Override
	public Customer getCustomer(String name,String password) {
		return customerDao.getCustomerByNamePassword(name, password);
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		List<Customer> customers=customerDao.findAll();
		for(Customer c:customers) {
			if(c.getCustomerName().equalsIgnoreCase(customer.getCustomerName()))
				return false;
		}
		customerDao.save(customer);
		return true;
	}

	@Override
	public boolean getCustomerByCustomerName(String name,String password) {
		Customer customer=customerDao.getCustomerByNamePassword(name, password);
		if(customer==null)
			return false;
		else
			return true;
	}

}
