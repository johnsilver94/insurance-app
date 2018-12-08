package com.model;

import com.enums.VehicleType;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "vehicleId")
	private BigInteger id;
	private String manufacturer;
	private Integer year;
    private String model;
    @Enumerated(EnumType.STRING)
    private VehicleType type; // enum type (Sedan, Coupe, Hatchback, Convertible, SUV, Motorcycle)
    private Double value; // car value, at the moment (?)
    private String observations;
    private Boolean inLeasing;
    private Boolean securitySystem;

    public Vehicle() {
        super();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Boolean getInLeasing() {
        return inLeasing;
    }

    public void setInLeasing(Boolean inLeasing) {
        this.inLeasing = inLeasing;
    }

    public Boolean getSecuritySystem() {
        return securitySystem;
    }

    public void setSecuritySystem(Boolean securitySystem) {
        this.securitySystem = securitySystem;
    }

    public Vehicle(String manufacturer, Integer year, String model, VehicleType type, Double value, String observations, Boolean inLeasing, Boolean securitySystem) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.model = model;
        this.type = type;
        this.value = value;
        this.observations = observations;
        this.inLeasing = inLeasing;
        this.securitySystem = securitySystem;
    }
}
