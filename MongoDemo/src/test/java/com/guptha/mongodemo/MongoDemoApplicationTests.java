package com.guptha.mongodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.mongodemo.model.Product;
import com.guptha.mongodemo.repos.ProductRepository;

@SpringBootTest
class MongoDemoApplicationTests {

	@Autowired
	ProductRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Mac Book pro");
		product.setPrice(2000f);
		Product savedProduct = repo.save(product);
		assertNotNull(savedProduct);
	}

	@Test
	void testFindAll() {

		List<Product> all = repo.findAll();
		assertEquals(1, all.size());
	}

	@Test
	void testDelete() {
		repo.deleteById("638450f96c2171451e2238ae");
		Optional<Product> product = repo.findById("638450f96c2171451e2238ae");
		assertEquals(Optional.empty(), product);

	}

	@Test
	void testUpdate() {
		Product product = repo.findById("63845334096c0e43b2eed58d").get();
		product.setPrice(1900f);
		repo.save(product);
	}
}
