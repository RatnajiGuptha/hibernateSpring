package com.guptha.springdata.transactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guptha.springdata.transactionmanagement.entities.BankAccount;
import com.guptha.springdata.transactionmanagement.repo.BankRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankRepository bankRepo;

	@Override
	@Transactional
	public void transfer(int amount) {
		BankAccount ratnajiAcc = bankRepo.findById(1).get();
		ratnajiAcc.setBal(ratnajiAcc.getBal() - amount);
		bankRepo.save(ratnajiAcc);

		if (true) {
			throw new RuntimeException();
		}
		BankAccount sunilAcc = bankRepo.findById(2).get();
		sunilAcc.setBal(sunilAcc.getBal() + amount);
		bankRepo.save(sunilAcc);
	}

}
