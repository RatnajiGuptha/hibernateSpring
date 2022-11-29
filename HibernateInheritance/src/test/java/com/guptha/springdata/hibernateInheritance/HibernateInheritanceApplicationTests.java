package com.guptha.springdata.hibernateInheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.springdata.hibernateInheritance.Repos.PaymentRepository;
import com.guptha.springdata.hibernateInheritance.enitites.Check;
import com.guptha.springdata.hibernateInheritance.enitites.CreditCard;

@SpringBootTest
class HibernateInheritanceApplicationTests {

	@Autowired
	PaymentRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	void createPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(12);
		cc.setAmount(1890);
		cc.setCreditNumber("34565432457889");
		repo.save(cc);
	}

//	@Test
	void createCheckPayment() {
		Check ch = new Check();
		ch.setId(109);
		ch.setAmount(19000);
		ch.setCheckNumber("ch56451678091");
		repo.save(ch);
	}

}
