package com.dmt.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dmt.modal.Customer;
import com.dmt.modal.Product;
import com.dmt.response.CustomerList;
import com.dmt.response.ProductDO;

@Component
public class DMTHelper {
 
	public List<CustomerList> generateCusotmerList(List<Customer> customers){
		List<CustomerList> customerList = new ArrayList<CustomerList>();
		for (Customer customer : customers) {
			CustomerList dmtCustomer = new CustomerList();
			dmtCustomer.setAddress(customer.getAddressLine1());
			dmtCustomer.setArea(customer.getArea());
			dmtCustomer.setCity(customer.getCity().getCityName());
			dmtCustomer.setCustomerCode(customer.getCustomerCode());
			dmtCustomer.setCustomerId(customer.getCustomerId());
			dmtCustomer.setCustomerName(customer.getName());
			customerList.add(dmtCustomer);
		}
		return customerList;
	}

	public List<ProductDO> generateProductDOList(List<Product> products) {
		List<ProductDO> productDOs = new ArrayList<ProductDO>();
		for (Product product : products) {
			ProductDO productDo = new ProductDO();
			productDo.setProductId(product.getProductId().toString());
			productDo.setBrand(product.getBrand().getBrandName());
			productDo.setHsnCode(product.getHsnCode());
			productDo.setProductCode(product.getProductName());
			productDo.setProductName(product.getProductName());
			productDo.setQuantityInHand(product.getQtyInHand());
			productDOs.add(productDo);
		}
		return productDOs;
	}
 	
}
