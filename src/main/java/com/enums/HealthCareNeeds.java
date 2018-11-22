package com.enums;

public enum HealthCareNeeds {
	LOW("Low use"),
	MEDIUM("Medium use"),
	HIGH("High use");
	
	private final String level;
	
	HealthCareNeeds(String level) {
        this.level = level;
    }

}
