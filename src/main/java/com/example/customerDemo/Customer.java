package com.example.customerDemo;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	private UUID id;

	private String name;

	private int age;

	public Customer(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("age") int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
