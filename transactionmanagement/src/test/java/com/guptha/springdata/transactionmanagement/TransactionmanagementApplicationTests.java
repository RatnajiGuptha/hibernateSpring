package com.guptha.springdata.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.springdata.transactionmanagement.entities.BankAccount;
import com.guptha.springdata.transactionmanagement.repo.BankRepository;
import com.guptha.springdata.transactionmanagement.service.BankAccountService;

@SpringBootTest
class TransactionmanagementApplicationTests {

	@Autowired
	BankRepository br;

	@Autowired
	BankAccountService service;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateBankAccounts() {
		BankAccount bankAcc1 = new BankAccount(1, "ratnaji", "guptha", 5000);
		BankAccount bankAcc2 = new BankAccount(2, "sunil", "dharmkar", 4000);
		br.save(bankAcc1);
		br.save(bankAcc2);
	}

	@Test
	void transfer() {
		service.transfer(500);
	}

}
