package com.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Travel")
public class TravelPolicy extends InsurancePolicy{
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TravePolicy_Destination", joinColumns = @JoinColumn(name = "policyId"), inverseJoinColumns = @JoinColumn(name = "countryId"))
	private List<Country> destinations;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TravePolicy_Customer", joinColumns = @JoinColumn(name = "policyId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	private List<Customer> beneficiaries;

	public TravelPolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan) {
		super(starDate, endDate, customer, plan);
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

	public List<Country> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Country> destinations) {
		this.destinations = destinations;
	}

	public List<Customer> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Customer> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public TravelPolicy() {
		super();
	}

	public TravelPolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan, List<Country> destinations, List<Customer> beneficiaries) {
		super(starDate, endDate, customer, plan);
		this.destinations = destinations;
		this.beneficiaries = beneficiaries;
	}
}
