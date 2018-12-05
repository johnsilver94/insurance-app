package com.model;

import java.util.Date;
import java.util.List;

import com.enums.CoverageLevel;

public class HealthPolicy extends InsurancePolicy{
    private CoverageLevel coverageLevel;
	private List<HealthData> beneficiaries;
}
