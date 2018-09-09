package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grn_account database table.
 * 
 */
@Entity
@Table(name="grn_account")
@NamedQuery(name="GrnAccount.findAll", query="SELECT g FROM GrnAccount g")
public class GrnAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="grn_account_grn_account_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grn_account_id")
	private Integer grnAccountId;

	private String amount;

	@Column(name="cash_discount")
	private String cashDiscount;
	
	@Column(name="grn_number")
	private String grnNumber;

	private String freight;

	private String gst;

	@Column(name="rounded_off")
	private String roundedOff;

	@Column(name="scheme_discount")
	private String schemeDiscount;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;


	public GrnAccount() {
	}

	public Integer getGrnAccountId() {
		return this.grnAccountId;
	}

	public void setGrnAccountId(Integer grnAccountId) {
		this.grnAccountId = grnAccountId;
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

	public String getFreight() {
		return this.freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getGst() {
		return this.gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}
	
}