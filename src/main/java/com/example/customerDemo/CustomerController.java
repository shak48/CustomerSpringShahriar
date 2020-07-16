package com.example.customerDemo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("customer")
@RestController
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping
	public void addCustomer(@RequestBody @NonNull Customer customer) {
		customerService.addCustomer(customer);

	}

	@GetMapping
	public List<Customer> getAllPeople() {
		return customerService.getAllPeople();

	}

	@GetMapping(path = "/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") UUID id) {
		return customerService.getCustomerById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCustomerById(@PathVariable("id") UUID id) {
		customerService.deleteCustomer(id);
	}

	@PutMapping(path = "/{id}")
	public void updateCustomer(@PathVariable("id") UUID id, @NonNull @RequestBody Customer customerToUpdate) {
		customerService.updateCustomer(id, customerToUpdate);

	}
}
