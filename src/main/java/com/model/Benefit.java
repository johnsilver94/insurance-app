package com.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import java.math.BigInteger;

@Entity
@Table(name = "Benefit")
public class Benefit {
	@Id
	@GeneratedValue
	@Column(name = "benefitId", unique = true,nullable = false)
	private BigInteger id;
	private String description;
	private Double amount;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Benefit(String description, Double amount) {
		this.description = description;
		this.amount = amount;
	}

	public Benefit() {
		super();
	}
}
