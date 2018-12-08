package com.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Auto")
public class AutoPolicy extends InsurancePolicy{
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "AutoPolicy_Beneficiaries", joinColumns = @JoinColumn(name = "policyId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	private List<Customer> beneficiaries;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "AutoPolicy_Vehicle", joinColumns = @JoinColumn(name = "policyId"), inverseJoinColumns = @JoinColumn(name = "vehicleId"))
	private List<Vehicle> vehicles;

	public AutoPolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan) {
		super(starDate, endDate, customer, plan);
	}

	public AutoPolicy() {
		super();
	}

	@Override
	public BigInteger getId() {
		return super.getId();
	}

	@Override
	public void setId(BigInteger id) {
		super.setId(id);
	}

	@Override
	public Date getStarDate() {
		return super.getStarDate();
	}

	@Override
	public void setStarDate(Date starDate) {
		super.setStarDate(starDate);
	}

	@Override
	public Date getEndDate() {
		return super.getEndDate();
	}

	@Override
	public void setEndDate(Date endDate) {
		super.setEndDate(endDate);
	}

	@Override
	public Customer getCustomer() {
		return super.getCustomer();
	}

	@Override
	public void setCustomer(Customer customer) {
		super.setCustomer(customer);
	}

	@Override
	public InsurancePlan getPlan() {
		return super.getPlan();
	}

	@Override
	public void setPlan(InsurancePlan plan) {
		super.setPlan(plan);
	}

	public List<Customer> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Customer> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public AutoPolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan, List<Customer> beneficiaries, List<Vehicle> vehicles) {
		super(starDate, endDate, customer, plan);
		this.beneficiaries = beneficiaries;
		this.vehicles = vehicles;
	}
}
