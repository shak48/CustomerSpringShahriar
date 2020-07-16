package com.flexon.customer.api;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexon.customer.model.Customer;
import com.flexon.customer.service.CustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	
	@Autowired
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping
	public ResponseEntity<List<Customer>> selectAllCustomers() {
		return customerService.selectAllCustomers();
		
	}
	@PostMapping
	private void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
}