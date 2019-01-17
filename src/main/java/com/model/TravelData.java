package com.model;

import com.enums.HealthCareNeeds;
import com.enums.Purpose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@XmlRootElement
@Entity
@Table(name = "TravelData")
public class TravelData {
	@Id
	@GeneratedValue
//	@Column(name = "travelId", unique = true,nullable = false)
	private BigInteger id;
	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	private Customer customer;
	@Enumerated(EnumType.STRING)
	private Purpose pourpose;

	//Getters
	@XmlAttribute
	public BigInteger getId() {
		return id;
	}
	@XmlAttribute
	public Customer getCustomer() {
		return customer;
	}
	@XmlAttribute
	public Purpose getPourpose() {
		return pourpose;
	}

	//Setters

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPourpose(Purpose pourpose) {
		this.pourpose = pourpose;
	}

	public TravelData() {
		super();
	}

	public TravelData(Customer customer, Purpose pourpose) {
		this.customer = customer;
		this.pourpose = pourpose;
	}
}
