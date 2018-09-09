package com.dmt.modal;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="product_product_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;

	@Column(name="product_name")
	private String productName;
	
	private String description;

	@Column(name="hsn_code")
	private String hsnCode;

	@Column(name="landing_price")
	private String landingPrice;

	private String mrp;
	
	@Column(name="selling_price")
	private String sellingPrice;

	@Column(name="product_number")
	private String productNumber;

	@Column(name="qty_in_hand")
	private String qtyInHand;

	//bi-directional many-to-one association to Brand
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@Transient
	private String brandName;
	
	@Transient
	private String productIDTemp;
	
	private String cgst;
	
	private String sgst;
	
	public Product() {
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHsnCode() {
		return this.hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getLandingPrice() {
		return this.landingPrice;
	}

	public void setLandingPrice(String landingPrice) {
		this.landingPrice = landingPrice;
	}

	public String getMrp() {
		return this.mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getQtyInHand() {
		return this.qtyInHand;
	}

	public void setQtyInHand(String qtyInHand) {
		this.qtyInHand = qtyInHand;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getProductIDTemp() {
		return productIDTemp;
	}

	public void setProductIDTemp(String productIDTemp) {
		this.productIDTemp = productIDTemp;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
}