package com.guptha.springdata.hibernateInheritance.Repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.hibernateInheritance.enitites.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
