package com.model;

import com.enums.Gender;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customerId",unique = true,nullable = false)
	private BigInteger id;
	private String name;
	private Date birthday;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String address;
	private String phonenumber;
	private String email;
	private String observations;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private AutoData autoData;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private HealthData healthData;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TravelData travelData;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
	private List<InsurancePolicy> customerPolicies;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public HealthData getHealthData() {
		return healthData;
	}

	public void setHealthData(HealthData healthData) {
		this.healthData = healthData;
	}

	public TravelData getTravelData() {
		return travelData;
	}

	public void setTravelData(TravelData travelData) {
		this.travelData = travelData;
	}

	public AutoData getAutoData() {
		return autoData;
	}

	public void setAutoData(AutoData autoData) {
		this.autoData = autoData;
	}

	public List<InsurancePolicy> getCustomerPolicies() {
		return customerPolicies;
	}

	public void setCustomerPolicies(List<InsurancePolicy> customerPolicies) {
		this.customerPolicies = customerPolicies;
	}

	public Customer(String name, Date birthday, Gender gender, String address, String phonenumber, String email, String observations, AutoData autoData, List<InsurancePolicy> customerPolicies) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.observations = observations;
		this.autoData = autoData;
		this.customerPolicies = customerPolicies;
	}

	public Customer() {
		super();
	}
}
