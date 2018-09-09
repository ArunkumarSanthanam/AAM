package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sale_order_accounts database table.
 * 
 */
@Entity
@Table(name="sale_order_accounts")
@NamedQuery(name="SaleOrderAccount.findAll", query="SELECT s FROM SaleOrderAccount s")
public class SaleOrderAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sale_order_accounts_order_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;

	private String amount;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@Column(name="gst_amount")
	private String gstAmount;

	@Column(name="sale_order_number")
	private String saleOrderNumber;
	
	private String status;

	public SaleOrderAccount() {
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getGstAmount() {
		return this.gstAmount;
	}

	public void setGstAmount(String gstAmount) {
		this.gstAmount = gstAmount;
	}

	public String getSaleOrderNumber() {
		return this.saleOrderNumber;
	}

	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}