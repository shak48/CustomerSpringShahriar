package com.flexon.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flexon.customer.dao.CustomerDao;
import com.flexon.customer.model.Customer;

@Service
public class CustomerService {
	
	public final CustomerDao customerDao;
	
	@Autowired
	public CustomerService(@Qualifier("Dao")CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public  ResponseEntity<List<Customer>> selectAllCustomers() {
		return customerDao.selectAllCustomers();
	}
	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}
}
