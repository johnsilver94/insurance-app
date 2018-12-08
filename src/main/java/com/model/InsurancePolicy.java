package com.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.enums.InsuranceType;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "insuranceType",discriminatorType = DiscriminatorType.STRING)
public abstract class InsurancePolicy {
    @Id
    @GeneratedValue
    @Column(name = "policyId",unique = true,nullable = false)
    private BigInteger id;
    private Date starDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private InsurancePlan plan;

    public InsurancePolicy(Date starDate, Date endDate, Customer customer, InsurancePlan plan) {
        this.starDate = starDate;
        this.endDate = endDate;
        this.customer = customer;
        this.plan = plan;
    }

    public InsurancePolicy() {
        super();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public InsurancePlan getPlan() {
        return plan;
    }

    public void setPlan(InsurancePlan plan) {
        this.plan = plan;
    }
}
