package com.guptha.springdata.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guptha.springdata.product.repos.ProductRepository;

@SpringBootApplication
public class ProductdataApplication implements CommandLineRunner {
	
	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	}

}
