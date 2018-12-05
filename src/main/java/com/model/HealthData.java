package com.model;

import java.util.List;

import com.enums.HealthCareNeeds;

public class HealthData {
	private Customer customer;
    private HealthCareNeeds healtcareNeeds;
    private Boolean isSmoker;
    private List<Disease> diseases;
    private List<Medication> medications;
}
