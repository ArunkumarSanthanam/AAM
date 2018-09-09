package com.dmt.response;

import java.util.List;

public class CustomerDTO {
	
	private List<CustomerList> customerList;
		
	private int count;

	public List<CustomerList> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerList> customerList) {
		this.customerList = customerList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
