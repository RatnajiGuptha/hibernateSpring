package com.guptha.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.guptha.springdata.associations.enitites.Customer;
import com.guptha.springdata.associations.enitites.PhoneNumber;
import com.guptha.springdata.associations.many2manyEnitites.Programmer;
import com.guptha.springdata.associations.many2manyEnitites.Project;
import com.guptha.springdata.associations.one2oneEntities.License;
import com.guptha.springdata.associations.one2oneEntities.Person;
import com.guptha.springdata.associations.repos.CustomerRepository;
import com.guptha.springdata.associations.repos.LicenseRepository;
import com.guptha.springdata.associations.repos.ProgrammerRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository cr;

	@Autowired
	ProgrammerRepository pr;

	@Autowired
	LicenseRepository lr;

	@Test
	void contextLoads() {
	}

//	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("ratnaji");

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("Cell");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0884567896");
		ph2.setType("LandLine.");

		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		cr.save(customer);
	}

	@Test
	@Transactional
	void testLoadCustomer() {
		Customer customer = cr.findById(1).get();
		System.out.println(customer.getName());

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(p -> System.err.println(p.getNumber()));
	}

//	@Test
	void testUpdateCustomer() {
		Customer customer = cr.findById(1).get();
		customer.setName("sri");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(p -> p.setType("cell"));

		cr.save(customer);
	}

//	@Test
	void testDelete() {
		cr.deleteById(1);
	}

//	@Test
	void testCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("guptha");
		programmer.setSal(10000);

		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();

		project.setName("Hiberate Project");
		projects.add(project);

		programmer.setProjects(projects);

		pr.save(programmer);
	}

	@Test
//	@Transactional
	void testFindProgrammer() {
		Programmer programmer = pr.findById(1).get();
		System.err.println(programmer);
		System.err.println(programmer.getProjects());
	}

	@Test
	void testCreateLicense() {
		License license = new License();
		license.setType("car");
		license.setValidFrom(new Date());
		license.setValiTo(new Date());

		Person person = new Person();
		person.setFirstName("ratnaji");
		person.setLastName("guptha");
		person.setAge(23);

		license.setPerson(person);
		lr.save(license);
	}

}
