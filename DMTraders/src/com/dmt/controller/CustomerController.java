package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmt.modal.Customer;
import com.dmt.modal.Supplier;
import com.dmt.response.CustomerDTO;
import com.dmt.response.SearchCriteria;
import com.dmt.service.customerService;
	
@Controller
public class CustomerController {
	@Autowired
	customerService customerService;
 	
	@RequestMapping(value = "/customerlist", method = RequestMethod.POST)
	@ResponseBody
	private CustomerDTO customerList(HttpServletRequest request, HttpServletResponse response,
			@RequestBody SearchCriteria searchCriteria) {
		CustomerDTO customerList = new CustomerDTO();
		customerList = customerService.getCustomerList(searchCriteria);
		return customerList;
	}
	
	@RequestMapping(value = "/getcustomer", method = RequestMethod.POST)
	@ResponseBody
	private Customer getCustomer(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("customerId") String customerId) {
		return customerService.getCustomer(customerId);
	}	
	
	@RequestMapping(value = "/getallcustomers", method = RequestMethod.POST)
	@ResponseBody
	private List<Customer> getAllCustomers(HttpServletRequest request, HttpServletResponse response) {
		return customerService.getAllCustomers();
	}	
	
	@RequestMapping(value = "/getallsuppliers", method = RequestMethod.POST)
	@ResponseBody
	private List<Supplier> getAllSuppliers(HttpServletRequest request, HttpServletResponse response) {
		return customerService.getAllSuppliers();
	}	
}
