package com.example.customerDemo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CustomerService {

	private final CustomerDao customerDao;

	@Autowired
	public CustomerService(@Qualifier("Dao") CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public int addCustomer(Customer customer) {
		return customerDao.insertCustomer(customer);
	}

	public List<Customer> getAllPeople() {
		return customerDao.selectAllPeople();

	}

	public Optional<Customer> getCustomerById(UUID id) {
		return customerDao.selectCustomerById(id);

	}

	public int deleteCustomer(UUID id) {
		return customerDao.deleteCustomerById(id);
	}

	public int updateCustomer(UUID id, Customer newCustomer) {
		return customerDao.updateCustomerById(id, newCustomer);
	}

}
