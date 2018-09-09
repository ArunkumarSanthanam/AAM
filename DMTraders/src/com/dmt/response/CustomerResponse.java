package com.dmt.response;

import java.util.List;

import com.dmt.modal.City;
import com.dmt.modal.District;
import com.dmt.modal.Taluk;

public class CustomerResponse {
	private List<City> cities;
	
	private List<District> districts;
	
	private List<Taluk> taluks;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public List<Taluk> getTaluks() {
		return taluks;
	}

	public void setTaluks(List<Taluk> taluks) {
		this.taluks = taluks;
	}
	
	
}
