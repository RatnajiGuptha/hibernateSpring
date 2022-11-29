package com.guptha.springdata.componentMapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.springdata.componentMapping.enitites.Address;
import com.guptha.springdata.componentMapping.enitites.Employee;
import com.guptha.springdata.componentMapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentMappingApplicationTests {

	@Autowired
	EmployeeRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	void createEmployee() {
		Employee emp = new Employee();
		Address ad = new Address();
		
		emp.setId(1);
		emp.setName("Guptha");		
		
		ad.setStreetaddress("waverock");
		ad.setCity("hyd");
		ad.setState("ts");
		ad.setZipcode("500008");
		ad.setCountry("india");
		
		emp.setAddress(ad);
		repo.save(emp);
	}

}
