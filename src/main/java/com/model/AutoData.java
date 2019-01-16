package com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import com.enums.DriverCategory;
import com.enums.DriverType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Entity
@Table(name = "AutoData")
public class AutoData {
	@Id
	@GeneratedValue
	@Column(name = "healthId",unique = true,nullable = false)
	private BigInteger id;
	@MapsId
    @OneToOne(fetch = FetchType.LAZY)
	private Customer customer;
	private String licenseid;
	private Integer exprience;
	private Integer accidents;
	@Enumerated(EnumType.STRING)
	private DriverCategory category;
	@Enumerated(EnumType.STRING)
	private DriverType type;

	//Getters
//	@XmlAttribute
	public Customer getCustomer() {
		return customer;
	}
	@XmlAttribute
	public String getLicenseId() {
		return licenseid;
	}
	@XmlAttribute
	public Integer getExprience() {
		return exprience;
	}
	@XmlAttribute
	public Integer getAccidents() {
		return accidents;
	}
	@XmlAttribute
	public DriverCategory getCategory() {
		return category;
	}
	@XmlAttribute
	public DriverType getType() {
		return type;
	}

	//Setters
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setLicenseId(String licenseid) {
		this.licenseid = licenseid;
	}

	public void setExprience(Integer exprience) {
		this.exprience = exprience;
	}

	public void setAccidents(Integer accidents) {
		this.accidents = accidents;
	}

	public void setCategory(DriverCategory category) {
		this.category = category;
	}

	public void setType(DriverType type) {
		this.type = type;
	}

	public AutoData() {
		super();
	}

	public AutoData(Customer customer, String licenseid, Integer exprience, Integer accidents, DriverCategory category, DriverType type) {
		this.customer = customer;
		this.licenseid = licenseid;
		this.exprience = exprience;
		this.accidents = accidents;
		this.category = category;
		this.type = type;
	}
}
