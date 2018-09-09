package com.dmt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmt.dao.CustomerDao;
import com.dmt.modal.Customer;
import com.dmt.modal.Supplier;
import com.dmt.response.CustomerDTO;
import com.dmt.response.SearchCriteria;
import com.dmt.service.customerService;

@Service
@Transactional
public class CustomerServiceImpl implements customerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public CustomerDTO getCustomerList(SearchCriteria searchCriteria) {
		return customerDao.getCustomerList(searchCriteria);
	}

	@Override
	public Customer getCustomer(String customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return customerDao.getAllSuppliers();
	}

}
