package com.flexon.customer.dao;

import java.util.*;

import org.springframework.http.ResponseEntity;

import com.flexon.customer.model.Customer;

public interface CustomerDao {

	int addCustomer(UUID id, Customer customer);

	default int addCustomer(Customer customer) {
		UUID id = UUID.randomUUID();
		return addCustomer(id, customer);
	}

	public ResponseEntity<List<Customer>> selectAllCustomers();

}
