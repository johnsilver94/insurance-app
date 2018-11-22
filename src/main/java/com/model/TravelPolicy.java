package com.model;

import java.util.List;

import com.enums.Country;

public class TravelPolicy extends InsurancePolicy{
	private List<Country> destinations;
	private List<TravelData> beneficiary;
}
