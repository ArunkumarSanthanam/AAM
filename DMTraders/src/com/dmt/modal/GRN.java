package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the grn database table.
 * 
 */
@Entity
@NamedQuery(name="GRN.findAll", query="SELECT g FROM GRN g")
public class GRN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="grn_grn_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grn_id")
	private Integer grnId;

	private String amount;

	@Column(name="cash_discount")
	private String cashDiscount;

	@Column(name="expiry_date")
	private Timestamp expiryDate;

	private String freight;

	@Column(name="grn_amount")
	private String grnAmount;

	@Column(name="grn_date")
	private Timestamp grnDate;

	@Column(name="grn_number")
	private String grnNumber;

	@Column(name="grn_type")
	private String grnType;

	@Column(name="gross_amount")
	private String grossAmount;

	private String gst;

	@Column(name="invoice_amount")
	private String invoiceAmount;

	@Column(name="invoice_date")
	private Timestamp invoiceDate;

	@Column(name="invoice_number")
	private String invoiceNumber;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;

	@Column(name="purchase_quantity")
	private String purchaseQuantity;

	@Column(name="purchase_rate")
	private String purchaseRate;

	@Column(name="purchase_type")
	private String purchaseType;

	@Column(name="rate_discount")
	private String rateDiscount;

	@Column(name="rounded_off")
	private String roundedOff;

	@Column(name="scheme_discount")
	private String schemeDiscount;

	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	public GRN() {
	}

	public Integer getGrnId() {
		return this.grnId;
	}

	public void setGrnId(Integer grnId) {
		this.grnId = grnId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCashDiscount() {
		return this.cashDiscount;
	}

	public void setCashDiscount(String cashDiscount) {
		this.cashDiscount = cashDiscount;
	}

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getFreight() {
		return this.freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getGrnAmount() {
		return this.grnAmount;
	}

	public void setGrnAmount(String grnAmount) {
		this.grnAmount = grnAmount;
	}

	public Timestamp getGrnDate() {
		return this.grnDate;
	}

	public void setGrnDate(Timestamp grnDate) {
		this.grnDate = grnDate;
	}

	public String getGrnNumber() {
		return this.grnNumber;
	}

	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}

	public String getGrnType() {
		return this.grnType;
	}

	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}

	public String getGrossAmount() {
		return this.grossAmount;
	}

	public void setGrossAmount(String grossAmount) {
		this.grossAmount = grossAmount;
	}

	public String getGst() {
		return this.gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Timestamp getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getPurchaseQuantity() {
		return this.purchaseQuantity;
	}

	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getPurchaseRate() {
		return this.purchaseRate;
	}

	public void setPurchaseRate(String purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public String getPurchaseType() {
		return this.purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public String getRateDiscount() {
		return this.rateDiscount;
	}

	public void setRateDiscount(String rateDiscount) {
		this.rateDiscount = rateDiscount;
	}

	public String getRoundedOff() {
		return this.roundedOff;
	}

	public void setRoundedOff(String roundedOff) {
		this.roundedOff = roundedOff;
	}

	public String getSchemeDiscount() {
		return this.schemeDiscount;
	}

	public void setSchemeDiscount(String schemeDiscount) {
		this.schemeDiscount = schemeDiscount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	

}