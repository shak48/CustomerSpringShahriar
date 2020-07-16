package com.flexon.customer.model;

import java.util.Random;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	//Customer customer =new Customer(null,null,null,null);
	private final UUID id ;
	private final String name;
	private final String gen;
	private final int age;
	public Customer(@JsonProperty("id") UUID id, @JsonProperty("name")String name, @JsonProperty("gen")String gen, @JsonProperty("age")int age) {
		super();
		this.id = id;
		this.name = name;
		this.gen = gen;
		this.age = age;
	}
	
	public Customer() {
		Random rand = new Random();
		this.id = UUID.randomUUID();
		this.name = "Demo Customer";
		this.gen = "M";
		this.age = rand.nextInt(40);
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGen() {
		return gen;
	}
	public int getAge() {
		return age;
	}



}
