package com.guptha.compositekey.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guptha.compositekey.entities.Customers;
import com.guptha.compositekey.entities.CustomerId;

public interface CustomerRepository extends JpaRepository<Customers, CustomerId> {

}
