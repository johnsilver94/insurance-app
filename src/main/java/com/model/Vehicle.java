package com.model;

import com.enums.VehicleType;

public class Vehicle {
	private Integer id; 
	private String manufacturer;
	private Integer year;
    private String model;
    private VehicleType type; // enum type (Sedan, Coupe, Hatchback, Convertible, SUV, Motorcycle)
    private Double value; // car value, at the moment (?)
    private String observations;
    private Boolean inLeasing;
    private Boolean securitySystem;
}
