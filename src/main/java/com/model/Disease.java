package com.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Disease")
public class Disease {
	@Id
	@GeneratedValue
	@Column(name = "diseaseId")
	private BigInteger id;
	private String name;

	public Disease() {
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

	public Disease(String name) {
		this.name = name;
	}
}
