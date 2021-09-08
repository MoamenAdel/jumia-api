package com.jumia.phonechecker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.phonechecker.model.CustomerModel;
import com.jumia.phonechecker.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("customer")
public class CustomerApiRestController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<CustomerModel> findItemInventoriesByItemId(
			@RequestParam(value = "country", required = false) String country, final Pageable pageable) {

		if (country != null && !country.isEmpty())
			return customerService.findCustomers(country, pageable);

		return customerService.findAllCustomers();
	}
}
