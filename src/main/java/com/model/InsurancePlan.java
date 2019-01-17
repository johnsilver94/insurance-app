package com.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "InsurancePlan")
public class InsurancePlan {
	@Id
	@GeneratedValue
	@Column(name = "planId")
	private BigInteger id;
	private String name;
	private String description;
	// price for year
	private Double price;
	@OneToOne(optional = false,mappedBy = "plan")
//	@JoinColumn(name="policyId", unique=true, nullable=false, updatable=false)
	private InsurancePolicy insurancePolicy;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "InsurancePlan_Coverage", joinColumns = @JoinColumn(name = "planId"), inverseJoinColumns = @JoinColumn(name = "coverageId"))
	private List<Coverage> coverages;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "InsurancePlan_Benefits", joinColumns = @JoinColumn(name = "planId"), inverseJoinColumns = @JoinColumn(name = "benefitId"))
	private List<Benefit> benefits;

	public InsurancePlan() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

	public List<Coverage> getCoverages() {
		return coverages;
	}

	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}

	public List<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	public InsurancePlan(String name, String description, Double price, InsurancePolicy insurancePolicy, List<Coverage> coverages, List<Benefit> benefits) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.insurancePolicy = insurancePolicy;
		this.coverages = coverages;
		this.benefits = benefits;
	}
}
