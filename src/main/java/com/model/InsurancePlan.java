package com.model;

import java.util.List;

import com.enums.InsuranceType;

public class InsurancePlan {
	private Integer id;
	private String name;
	private String description;
	// price for year
	private Double price;
	private List<Coverage> coverages;
	private List<Benefit> benefits;
}
