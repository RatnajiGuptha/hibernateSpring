package com.guptha.springdata.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.associations.enitites.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
