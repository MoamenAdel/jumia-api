package com.jumia.phonechecker.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jumia.phonechecker.model.CustomerModel;

public interface CustomerService {

	List<CustomerModel> findCustomers(String country, Pageable pageable);

	List<CustomerModel> findAllCustomers();
}
