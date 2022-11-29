package com.guptha.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.compositekey.entities.CustomerId;
import com.guptha.compositekey.entities.Customers;
import com.guptha.compositekey.repos.CustomerRepository;

@SpringBootTest
class CompositekeyApplicationTests {

	@Autowired
	CustomerRepository repo;

	@Test
	void testSaveCustomer() {

		Customers customer = new Customers();
		CustomerId id = new CustomerId();
		
		id.setId(2345);
		id.setEmail("test@test.com");
		
		customer.setId(id);
		customer.setName("test");
		
		repo.save(customer);

	}

}
