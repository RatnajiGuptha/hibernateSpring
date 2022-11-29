package com.guptha.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.guptha.springdata.product.entities.Product;
import com.guptha.springdata.product.repos.ProductRepository;
import com.mysql.cj.xdevapi.SessionFactory;

@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository repo;

	@Autowired
	EntityManager entityManger;

//	@Test
	void contextLoads() {
	}

	// @Test
	void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(10000d);

		repo.save(product);
	}

//	@Test
	void testRead() {
		Product product = repo.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.err.println(">>>>>>>>>>>>>>>>>> " + product.getDesc() + " <<<<<<<<<<<<<<<<");
	}

//	@Test
	void testUpdate() {
		Product product = repo.findById(1).get();
		product.setPrice(15000d);
		repo.save(product);
		System.err.println(">>>>>>>>>>>>>>>>" + product.toString());

	}

//	@Test
	void testDelete() {
		if (repo.existsById(1)) {
			repo.deleteById(1);
		}
	}

//	@Test
	void testCount() {
		System.out.println("total records " + repo.count());
	}

//	@Test
	void testReadAll() {
		List<Product> allproducts = (List<Product>) repo.findAll();

		allproducts.forEach(p -> System.out.println(p.toString()));
	}

//	@Test
	void testFindByName() {
		List<Product> product = repo.findByName("Water - Evian 355 Ml");
		product.forEach(p -> System.err.println(p.toString()));
	}

	// @Test
	void testFindByNameAndDesc() {
		List<Product> product = repo.findByNameAndDesc("Water - Evian 355 Ml", "Water - Evian 355 Ml");
		product.forEach(p -> System.err.println(p.toString()));
	}

//	@Test
	void testFindByPriceGreatherThan() {
		List<Product> product = repo.findByPriceGreaterThan(600d);
		product.forEach(p -> System.err.println(p.toString()));
	}

//	@Test
	void testFindByDescContains() {
		List<Product> product = repo.findByDescContains("water");
		product.forEach(p -> System.err.println(p.toString()));
	}

//	@Test
	void testFindByPriceBetween() {
		List<Product> product = repo.findByPriceBetween(600d, 900d);
		product.forEach(p -> System.err.println(p.toString()));
	}

//	@Test
	void testFindByDsecLike() {
		List<Product> product = repo.findByDescLike("%w%");
		product.forEach(p -> System.err.println(p.toString()));
	}

//	@Test
	void testFindByIdIn() {
		Pageable pageable = PageRequest.of(0, 5);
		List<Product> product = repo.findByIdIn(Arrays.asList(1, 2, 5, 7, 9), pageable);
		product.forEach(p -> System.err.println(p.toString()));
	}

//	@Test
	void testFindAllPaging() {
		Pageable pageable = PageRequest.of(5, 5);
		Page<Product> product = repo.findAll(pageable);
		product.forEach(p -> System.err.println(p.getName()));

	}

//	@Test
	void testFindAllSorting() {
		repo.findAll(Sort.by(Direction.DESC, "name")).forEach(p -> System.err.println(p.getName()));
		repo.findAll(Sort.by(Sort.Order.asc("name"), Sort.Order.desc("price")))
				.forEach(P -> System.err.println(P.getName()));

	}

//	@Test
	void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(5, 5, Sort.by(Sort.Order.asc("price"), Sort.Order.asc("name")));
		repo.findAll(pageable).forEach(p -> System.err.println(p.getName()));

	}

//	@Test
	@Transactional
	void testCashing() {
		Session session = entityManger.unwrap(Session.class);
		Product product = repo.findById(2).get();
		repo.findById(2);

		session.evict(product);
		repo.findById(2);
	}

//	@Test
	void testFindAllProducts() {
		System.err.println(repo.findAllProducts());
	}

//	@Test
	void testFindAllProductsByprice() {
		System.err.println(repo.findAllProductsByPrice(500));
	}

	@Test
	void testFindAllProductsCountByprice() {
		System.err.println(repo.findAllProductsCountByPrice(500));
	}

}
