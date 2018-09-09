package com.dmt.response;

import java.util.List;

import com.dmt.modal.Brand;
import com.dmt.modal.Customer;
import com.dmt.modal.Product;
import com.dmt.modal.Supplier;

public class SaleOrderResponse {
	private List<Product> products;
	
	private Customer customer;
	
	private List<Customer> customers;
	
	private List<Brand> brands;
	
	private String saleOrderNumber;
	
	private Supplier supplier;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public String getSaleOrderNumber() {
		return saleOrderNumber;
	}

	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
