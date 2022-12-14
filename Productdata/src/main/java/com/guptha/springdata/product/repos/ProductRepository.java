package com.guptha.springdata.product.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.guptha.springdata.product.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescContains(String string);

	List<Product> findByPriceBetween(Double price1, Double price2);

	List<Product> findByDescLike(String desc);

	List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

	@Query(value = "CALL GetAllProducts", nativeQuery = true)
	List<Product> findAllProducts();

	@Query(value = "CALL GetAllProductsByPrice (:price_in)", nativeQuery = true)
	List<Product> findAllProductsByPrice(double price_in);

	@Query(value = "CALL GetAllProductsCountByPrice (:price_in)", nativeQuery = true)
	int findAllProductsCountByPrice(double price_in);
}
