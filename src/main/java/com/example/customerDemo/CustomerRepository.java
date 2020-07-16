package com.example.customerDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component("Dao")
public class CustomerRepository implements CustomerDao {

	private static List<Customer> DB = new ArrayList<>();

	@Override
	public int insertCustomer(UUID id, Customer customer) {
		DB.add(new Customer(id, customer.getName(), customer.getAge()));
		return 1;
	}

	@Override
	public List<Customer> selectAllPeople() {
		return DB;

	}

	@Override
	public Optional<Customer> selectCustomerById(UUID id) {
		return DB.stream().filter(customer -> customer.getId().equals(id)).findFirst();
	}

	@Override
	public int deleteCustomerById(UUID id) {
		Optional<Customer> customerX = selectCustomerById(id);
		if (customerX.isPresent() != true) {
			return 0;
		}
		DB.remove(customerX.get());
		return 1;
	}

	@Override
	public int updateCustomerById(UUID id, Customer customerToUpdate) {
		return selectCustomerById(id).map(customer -> {
			int indexOfCustomerToUpdate = DB.indexOf(customer);
			if (indexOfCustomerToUpdate >= 0) {
				DB.set(indexOfCustomerToUpdate, new Customer(id, customerToUpdate.getName(), customerToUpdate.getAge()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}

}
