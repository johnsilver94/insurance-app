package com.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import com.enums.DriverCategory;
import com.enums.DriverType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigInteger;

@Entity
@Table(name = "AutoData")
public class AutoData {
	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true,nullable = false)
	private BigInteger id;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
	private Customer customer;
	// in years
	private Integer drivingExperience;
	private Integer accidentInvolved;
	@Enumerated(EnumType.STRING)
	private DriverCategory driverCategory;
	@Enumerated(EnumType.STRING)
	private DriverType driverType;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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

	public AutoData(Customer customer, Integer drivingExperience, Integer accidentInvolved, DriverCategory driverCategory) {
		this.customer = customer;
		this.drivingExperience = drivingExperience;
		this.accidentInvolved = accidentInvolved;
		this.driverCategory = driverCategory;
	}

	public AutoData() {
		super();
	}
}
