package com.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Country")
public class Country {
	@Id
	@GeneratedValue
	@Column(name = "countryId")
	private BigInteger id;
	private String code;
	private String name;

	public Country() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
