package com.dmt.dao;

import java.util.List;

import com.dmt.modal.Customer;
import com.dmt.modal.Supplier;
import com.dmt.response.CustomerDTO;
import com.dmt.response.SearchCriteria;

public interface CustomerDao {
	
	public CustomerDTO getCustomerList(SearchCriteria searchCriteria);
	
	public Customer getCustomer(String customerId);
	
	public List<Customer> getAllCustomers();
	
	public List<Supplier> getAllSuppliers();
}
