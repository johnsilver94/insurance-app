package com.enums;

public enum Purpose {
	BUSINESS("Business"),
	SPORT("Sport"),
	REST("Rest");
	
	private final String purpose;
	
	Purpose(String purpose) {
        this.purpose = purpose;
    }
}
