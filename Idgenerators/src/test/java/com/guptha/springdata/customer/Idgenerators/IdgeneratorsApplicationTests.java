package com.guptha.springdata.customer.Idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.springdata.customer.Idgenerators.enitites.Employee;
import com.guptha.springdata.customer.Idgenerators.repo.EmployeeRepo;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepo repo;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateEmployee() {
		Employee emp = new Employee();
		emp.setName("guptha");
		repo.save(emp);
		System.err.println(">>>>>>>>>>>> " + emp.toString() + " <<<<<<<<<<<<<<<<<<");
	}

}
