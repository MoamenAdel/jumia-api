package com.jumia.phonechecker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.phonechecker.entity.Customer;
import com.jumia.phonechecker.model.CustomerModel;
import com.jumia.phonechecker.model.NumberEnum;
import com.jumia.phonechecker.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerModel> findCustomers(String country, Pageable pageable) {
		for (NumberEnum ne : NumberEnum.values()) {
			if(ne.getCountryName().equalsIgnoreCase(country))
				return customerRepository.findCustomers("("+ne.getCountryCode()+")", pageable).stream().map(this::mappingToModel)
						.collect(Collectors.toList());
		}
		return new ArrayList<CustomerModel>();
		
	}

	@Override
	public List<CustomerModel> findAllCustomers() {
		return customerRepository.findAll().stream().map(this::mappingToModel).collect(Collectors.toList());
	}

	private CustomerModel mappingToModel(Customer customer) {
		CustomerModel model = new CustomerModel();
		model.setName(customer.getName());

		validatePhoneNumber(model, customer.getPhone());
		return model;
	}

	private void validatePhoneNumber(CustomerModel model, String phoneDB) {
		model.setValid(false);
		model.setCountryCode("+" + phoneDB.substring(1, 4));
		model.setPhoneNumber(phoneDB.substring(6));
		for (NumberEnum ne : NumberEnum.values()) {

			if (phoneDB.matches(ne.getCountryRegex())) {
				model.setValid(true);
				model.setCountryName(ne.getCountryName());
			} else if (phoneDB.startsWith("(" + ne.getCountryCode() + ")")) {
				model.setCountryName(ne.getCountryName());
			}

		}
	}

}
