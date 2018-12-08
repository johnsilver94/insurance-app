package com.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Coverage")
public class Coverage {
	@Id
	@GeneratedValue
	@Column(name = "coverageId")
	private BigInteger id;
	private String name;
	private String description;

	public Coverage() {
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

	public Coverage(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
