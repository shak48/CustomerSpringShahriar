package com.flexon.customer.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexon.customer.model.Customer;

@Repository("Dao")
public class CustomerRepository implements CustomerDao {

	private static List<Customer> DB = new ArrayList<Customer>();
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 @Bean
	    public Customer Customer() {
	        return new Customer();
	    }
	
	@Override
	public ResponseEntity<List<Customer>> selectAllCustomers() {
		String sql = "SELECT * FROM cs";
	    List<Customer> customers = new ArrayList<>();
		customers = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Customer>(Customer.class));
	    return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}

	@Override
	public int addCustomer(UUID id,Customer customer) {
		String sql = "INSERT INTO cs VALUES (id,name,gen,age)";
		//jdbcTemplate.s
		jdbcTemplate.execute(sql);
		return 1;
	}




	
	
	
}

