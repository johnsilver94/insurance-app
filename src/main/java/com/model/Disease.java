package com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@XmlRootElement
@Entity
@Table(name = "Disease")
public class Disease {
	@Id
	@GeneratedValue
	@Column(name = "diseaseId")
	private BigInteger id;
	private String name;

	//Getters
	@XmlAttribute
	public BigInteger getId() {
		return id;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}

	//Setters

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Disease() {
		super();
	}

	public Disease(String name) {
		this.name = name;
	}
}
