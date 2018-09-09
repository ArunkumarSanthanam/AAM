package com.dmt.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the district database table.
 * 
 */
@Entity
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="customer_district_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="district_id")
	private Integer districtId;

	@Column(name="distrct_description")
	private String distrctDescription;

	@Column(name="district_code")
	private String districtCode;

	@Column(name="district_name")
	private String districtName;
	
	@Transient
	private String districtIDTemp;

	public District() {
	}

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrctDescription() {
		return this.distrctDescription;
	}

	public void setDistrctDescription(String distrctDescription) {
		this.distrctDescription = distrctDescription;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictIDTemp() {
		return districtIDTemp;
	}

	public void setDistrictIDTemp(String districtIDTemp) {
		this.districtIDTemp = districtIDTemp;
	}
	
}