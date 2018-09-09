package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invoice_accounts database table.
 * 
 */
@Entity
@Table(name="invoice_accounts")
@NamedQuery(name="InvoiceAccount.findAll", query="SELECT i FROM InvoiceAccount i")
public class InvoiceAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="invoice_accounts_invoice_account_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoice_account_id")
	private Integer invoiceAccountId;

	private String amount;

	private String gst;

	@Column(name="sale_order_number")
	private String saleOrderNumber;

	public InvoiceAccount() {
	}

	public Integer getInvoiceAccountId() {
		return this.invoiceAccountId;
	}

	public void setInvoiceAccountId(Integer invoiceAccountId) {
		this.invoiceAccountId = invoiceAccountId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getGst() {
		return this.gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getSaleOrderNumber() {
		return this.saleOrderNumber;
	}

	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}

}