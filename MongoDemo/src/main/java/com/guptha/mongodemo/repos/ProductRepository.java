package com.guptha.mongodemo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guptha.mongodemo.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
