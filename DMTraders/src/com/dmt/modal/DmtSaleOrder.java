package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dmt_sale_order database table.
 * 
 */
@Entity
@Table(name="dmt_sale_order")
@NamedQuery(name="DmtSaleOrder.findAll", query="SELECT d FROM DmtSaleOrder d")
public class DmtSaleOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sale_order_sale_order_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sale_order_id")
	private Integer saleOrderId;

	private String amount;

	@Column(name="bill_qty")
	private String billQty;

	@Column(name="cgst_amount")
	private String cgstAmount;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@Column(name="date_created")
	private Timestamp dateCreated;

	@Column(name="gross_total")
	private String grossTotal;

	@Column(name="net_rate")
	private String netRate;

	@Column(name="order_qty")
	private String orderQty;

	@Column(name="picking_qty")
	private String pickingQty;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;

	@Column(name="sale_order_number")
	private String saleOrderNumber;

	@Column(name="sgst_amount")
	private String sgstAmount;

	private String discount;
	
	public DmtSaleOrder() {
	}

	public Integer getSaleOrderId() {
		return this.saleOrderId;
	}

	public void setSaleOrderId(Integer saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBillQty() {
		return this.billQty;
	}

	public void setBillQty(String billQty) {
		this.billQty = billQty;
	}

	public String getCgstAmount() {
		return this.cgstAmount;
	}

	public void setCgstAmount(String cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getGrossTotal() {
		return this.grossTotal;
	}

	public void setGrossTotal(String grossTotal) {
		this.grossTotal = grossTotal;
	}

	public String getNetRate() {
		return this.netRate;
	}

	public void setNetRate(String netRate) {
		this.netRate = netRate;
	}

	public String getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getPickingQty() {
		return this.pickingQty;
	}

	public void setPickingQty(String pickingQty) {
		this.pickingQty = pickingQty;
	}

	public String getSaleOrderNumber() {
		return this.saleOrderNumber;
	}

	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}

	public String getSgstAmount() {
		return this.sgstAmount;
	}

	public void setSgstAmount(String sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
}