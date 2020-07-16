package com.example.customerDemo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {
	
	default int insertCustomer(Customer customer) {
		UUID id = UUID.randomUUID();
		return insertCustomer(id, customer);
	}

	int insertCustomer(UUID id, Customer customer);

	List<Customer> selectAllPeople();

	Optional<Customer> selectCustomerById(UUID id);

	int deleteCustomerById(UUID id);

	int updateCustomerById(UUID id, Customer cutomer);
}
