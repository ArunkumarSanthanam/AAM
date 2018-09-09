package com.dmt.response;

public class ProductDO {
	private String brand;
	
	private String productId;
	
	private String productName;
	
	private String productCode;
	
	private String hsnCode;
	
	private String quantityInHand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getQuantityInHand() {
		return quantityInHand;
	}

	public void setQuantityInHand(String quantityInHand) {
		this.quantityInHand = quantityInHand;
	}
	
}
