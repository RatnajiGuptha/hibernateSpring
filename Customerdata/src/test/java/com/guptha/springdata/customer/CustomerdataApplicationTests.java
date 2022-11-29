package com.guptha.springdata.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.guptha.springdata.customer.enitites.Customer;
import com.guptha.springdata.customer.repo.CustomerRepository;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository repo;

	// @Test
	void contextLoads() {
	}

//	@Test
	void testCreate() {
		Customer customer = new Customer();
		customer.setName("guptha");
		customer.setEmail("guptha@gmail.com");
		repo.save(customer);
		System.err.println(customer.toString());
	}

//	@Test
	void testCustomerName() {
		Customer customer = repo.findById(1).get();
		assertEquals("guptha", customer.getName());
//		assertEquals("guptha@gmail.com", customer.getEmail());
	}

//	@Test
	void testRead() {
		Customer customer = repo.findById(1).get();
		System.err.println(">>>>>>>>>" + customer.toString() + "<<<<<<<<<<");
	}

//	@Test
	void testUpdate() {
		Customer customer = repo.findById(1).get();
		customer.setName("ratnaji");
		repo.save(customer);
		System.err.println(">>>>>>>>>" + customer.toString() + "<<<<<<<<<<");
	}

//	@Test
	void testDelete() {
		if (repo.existsById(1)) {
			repo.deleteById(1);
			System.err.println("Customer deleted...");
		}
	}

//	@Test
	void testCount() {
		System.err.println("Total records in database :" + repo.count());
	}

//	@Test
	void testFindByEmailAndName() {
		List<Customer> customers = repo.findByEmailAndName("guptha@gmail.com", "guptha");
		customers.forEach(c -> System.err.println(c.toString()));
	}

	@Test
	void testFindByEmailLike() {
		List<Customer> customers = repo.findByEmailLike("%guptha%");
		customers.forEach(c -> System.err.println(c.toString()));
	}

//	@Test
	void testFindByIdIn() {
		List<Customer> customers = repo.findByIdIn(Arrays.asList(1, 8, 4, 9),
				PageRequest.of(0, 2, Direction.DESC, "name"));
		customers.forEach(c -> System.err.println(c.toString()));
	}

//	@Test
	@Transactional
	@Rollback(false)
	void testUpdateCustomer() {
		repo.updateCustomerEmailById("ratnaji@gmail.com", 9);
	}

}
