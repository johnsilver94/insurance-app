package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.enums.DriverCategory;
import com.enums.DriverType;

@Entity
public class AutoData {
	@Id
	private Integer id;
	//private Customer customer;
	// in years
	private Integer drivingExperience;
	private Integer accidentInvolved;
	private DriverCategory driverCategory;
	private DriverType driverType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	*/
	public Integer getDrivingExperience() {
		return drivingExperience;
	}
	public void setDrivingExperience(Integer drivingExperience) {
		this.drivingExperience = drivingExperience;
	}
	public Integer getAccidentInvolved() {
		return accidentInvolved;
	}
	public void setAccidentInvolved(Integer accidentInvolved) {
		this.accidentInvolved = accidentInvolved;
	}
	public DriverCategory getDriverCategory() {
		return driverCategory;
	}
	public void setDriverCategory(DriverCategory driverCategory) {
		this.driverCategory = driverCategory;
	}
	public DriverType getDriverType() {
		return driverType;
	}
	public void setDriverType(DriverType driverType) {
		this.driverType = driverType;
	}
	public AutoData(Integer id, Customer customer, Integer drivingExperience, Integer accidentInvolved,
			DriverCategory driverCategory, DriverType driverType) {
		super();
		this.id = id;
		//this.customer = customer;
		this.drivingExperience = drivingExperience;
		this.accidentInvolved = accidentInvolved;
		this.driverCategory = driverCategory;
		this.driverType = driverType;
	}
	public AutoData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
