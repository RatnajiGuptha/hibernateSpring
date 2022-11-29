package com.guptha.springdata.transactionmanagement.repo;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.transactionmanagement.entities.BankAccount;

public interface BankRepository extends CrudRepository<BankAccount, Integer> {

}
