package com.jumia.phonechecker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jumia.phonechecker.entity.Customer;
import com.jumia.phonechecker.model.CustomerModel;
import com.jumia.phonechecker.model.NumberEnum;
import com.jumia.phonechecker.repository.CustomerRepository;
import com.jumia.phonechecker.service.CustomerService;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PhonecheckerApplicationTests {
	@Autowired
	CustomerRepository cusomterRepository;
	@Autowired
	CustomerService customerService;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testRepo() {
		List<Customer> customers = cusomterRepository.findAll();
		assertThat(customers).size().isPositive();
	}

	@Test
	void testService() {
		NumberEnum ne = NumberEnum.CAMEROON;
		String country = ne.getCountryName();
		List<CustomerModel> customers = customerService.findCustomers(country, null);
		assertThat(customers).allMatch(item -> "+237".equals(item.getCountryCode()));
	}

	@Test
	void testApi() throws Exception {
		 this.mockMvc.perform(MockMvcRequestBuilders.get("/customer").param("country", "Cameroon"))
         .andExpect(MockMvcResultMatchers.status().isOk()) .andDo(MockMvcResultHandlers.print());
         }

}
