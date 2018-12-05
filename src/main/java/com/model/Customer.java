package com.model;

import java.util.Date;
import java.util.List;

public class Customer {
	private Integer id;
	private String name;
	private Date birthday;
	private Enum gender;
	private String address;
	private String phonenumber;
	private String email;
	private String observations;
	private List<InsurancePolicy> customerPolicies; 
	
}
