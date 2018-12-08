package com.model;

import com.enums.HealthCareNeeds;
import com.enums.Purpose;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TravelData")
public class TravelData {
	@Id
	@GeneratedValue
	@Column(name = "travelId", unique = true,nullable = false)
	private BigInteger id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	private Customer customer;
	@Enumerated(EnumType.STRING)
	private Purpose pourpose;

	public TravelData() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Purpose getPourpose() {
		return pourpose;
	}

	public void setPourpose(Purpose pourpose) {
		this.pourpose = pourpose;
	}

	public TravelData(Customer customer, Purpose pourpose) {
		this.customer = customer;
		this.pourpose = pourpose;
	}
}
