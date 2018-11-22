package com.model;

import java.util.List;

import com.enums.Disease;
import com.enums.Medication;

public class HealthData {
	private Customer customer;
    private Enum healtcareNeeds;
    private Boolean isSmoker;
    private List<Disease> diseases;
    private List<Medication> medications;
}
