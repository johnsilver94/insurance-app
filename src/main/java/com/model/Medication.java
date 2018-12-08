package com.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Medication")
public class Medication {
	@Id
	@GeneratedValue
	@Column(name = "medicationId")
	private BigInteger id;
	private String name;

	public Medication() {
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

	public Medication(String name) {
		this.name = name;
	}
}
