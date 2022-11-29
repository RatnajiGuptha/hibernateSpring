package com.guptha.springdata.componentMapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.componentMapping.enitites.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
