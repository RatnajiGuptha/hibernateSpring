package com.guptha.springdata.customer.Idgenerators.repo;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.customer.Idgenerators.enitites.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long>{

}
