package com.enums;

public enum DriverType {
	TAXIDRIVER("Taxicab driver"),
	UBERDRIVER("Uber Driver"),
	CHAUFFEUR("Chauffeur"),
	PAYDRIVER("Pay driver"),
	TESTDRIVER("Test driver"),
	DELIVERY("Delivery (commerce)"),
	BUSDRIVER("Bus driver"),
	TRUCKDRIVER("Truck driver"),
	MOTORMAN("Motorman");
	
	private final String type;
	
	DriverType(String type) {
        this.type = type;
    }
}
