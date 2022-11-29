package com.guptha.springdata.customer.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.guptha.springdata.customer.enitites.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

	List<Customer> findByEmailAndName(String eMail, String name);

	List<Customer> findByEmailLike(String eMail);

	List<Customer> findByIdIn(List<Integer> ids, Pageable pageable);

	@Modifying
	@Query("Update Customer set email = :email where id = :id ")
	void updateCustomerEmailById(@Param("email") String email, @Param("id") int id);
}
