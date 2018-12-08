package com.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.enums.CoverageLevel;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Health")
public class HealthPolicy extends InsurancePolicy{
    @Enumerated(EnumType.STRING)
    private CoverageLevel coverageLevel;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "HealthPolicy_Beneficiaries",joinColumns = @JoinColumn(name = "policyId"),inverseJoinColumns = @JoinColumn(name = "customerId"))
	private List<Customer> beneficiaries;

    public HealthPolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan) {
        super(starDate, endDate, customer, plan);
    }

    public HealthPolicy() {
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

    public CoverageLevel getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(CoverageLevel coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public List<Customer> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Customer> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public HealthPolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan, CoverageLevel coverageLevel, List<Customer> beneficiaries) {
        super(starDate, endDate, customer, plan);
        this.coverageLevel = coverageLevel;
        this.beneficiaries = beneficiaries;
    }
}
