package com.jumia.phonechecker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jumia.phonechecker.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.phone  like ?1% ")
	public Page<Customer> findCustomers(String country, Pageable pageable);

}
