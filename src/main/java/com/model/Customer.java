package com.model;

import com.enums.Gender;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "id",unique = true,nullable = false)
	private BigInteger id;
	private String email;
	@Column(name = "username",unique = true)
	private String username;
	private String password;
	private boolean beneficiary;
	private String observations;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Profile profile;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private AutoData autodata;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private HealthData healthdata;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TravelData traveldata;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
	private List<InsurancePolicy> policies;

	//Getters
	@XmlAttribute
	public BigInteger getId() {
		return id;
	}
	@XmlAttribute
	public String getEmail() {
		return email;
	}
	@XmlAttribute
	public String getUsername() {
		return username;
	}
	@XmlAttribute
	public String getPassword() {
		return password;
	}
	@XmlAttribute
	public boolean isBeneficiary() {
		return beneficiary;
	}
	@XmlAttribute
	public String getObservations() {
		return observations;
	}
	@XmlAttribute
	public Profile getProfile() {
		return profile;
	}
	@XmlAttribute
	public AutoData getAutodata() {
		return autodata;
	}
	@XmlAttribute
	public HealthData getHealthdata() {
		return healthdata;
	}
	@XmlAttribute
	public TravelData getTraveldata() {
		return traveldata;
	}
	@XmlAttribute
	public List<InsurancePolicy> getPolicies() {
		return policies;
	}
	//Setters

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBeneficiary(boolean beneficiary) {
		this.beneficiary = beneficiary;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setAutodata(AutoData autodata) {
		this.autodata = autodata;
	}

	public void setHealthdata(HealthData healthdata) {
		this.healthdata = healthdata;
	}

	public void setTraveldata(TravelData traveldata) {
		this.traveldata = traveldata;
	}

	public void setPolicies(List<InsurancePolicy> policies) {
		this.policies = policies;
	}

	public Customer() {
		super();
	}

	public Customer(String email, String username, String password, boolean beneficiary, String observations, Profile profile, AutoData autodata, HealthData healthdata, TravelData traveldata, List<InsurancePolicy> policies) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.beneficiary = beneficiary;
		this.observations = observations;
		this.profile = profile;
		this.autodata = autodata;
		this.healthdata = healthdata;
		this.traveldata = traveldata;
		this.policies = policies;
	}
}
