package com.enums;

public enum InsuranceType {
	HEALTH("Health"),
	AUTO("Auto"),
	TRAVEL("Travel"),
	PROPERTY("Property");
	
	
	private final String type;
	
	InsuranceType(String type) {
        this.type = type;
    }
}
