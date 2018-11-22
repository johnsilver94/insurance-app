package com.enums;

public enum VehicleType {
	HATCHBACK("Hatchback"),
	SEDAN("Sedan"),
	MPV("MPV"),
	SUV("SUV"),
	CROSSOVER("Crossover"),
	COUPE("Coupe"),
	CONVERTIBLE("Convertible");
	
	private final String type;
	
	VehicleType(String type) {
        this.type = type;
    }

}
