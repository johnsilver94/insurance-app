package com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@XmlRootElement
@Entity
@Table(name = "Medication")
public class Medication {
	@Id
	@GeneratedValue
	@Column(name = "medicationId")
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

	public Medication() {
		super();
	}

	public Medication(String name) {
		this.name = name;
	}
}
