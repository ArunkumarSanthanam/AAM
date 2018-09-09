package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the taluk database table.
 * 
 */
@Entity
@NamedQuery(name="Taluk.findAll", query="SELECT t FROM Taluk t")
public class Taluk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="customer_taluk_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taluk_id")
	private Integer talukId;

	@Column(name="taluk_code")
	private String talukCode;

	@Column(name="taluk_description")
	private String talukDescription;

	@Column(name="taluk_name")
	private String talukName;
	
	@Transient
	private String talukIDTemp;

	public Taluk() {
	}

	public Integer getTalukId() {
		return this.talukId;
	}

	public void setTalukId(Integer talukId) {
		this.talukId = talukId;
	}

	public String getTalukCode() {
		return this.talukCode;
	}

	public void setTalukCode(String talukCode) {
		this.talukCode = talukCode;
	}

	public String getTalukDescription() {
		return this.talukDescription;
	}

	public void setTalukDescription(String talukDescription) {
		this.talukDescription = talukDescription;
	}

	public String getTalukName() {
		return this.talukName;
	}

	public void setTalukName(String talukName) {
		this.talukName = talukName;
	}

	public String getTalukIDTemp() {
		return talukIDTemp;
	}

	public void setTalukIDTemp(String talukIDTemp) {
		this.talukIDTemp = talukIDTemp;
	}
}