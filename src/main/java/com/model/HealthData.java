package com.model;

import java.math.BigInteger;
import java.util.List;

import com.enums.HealthCareNeeds;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "HealthData")
public class HealthData {
    @Id
    @GeneratedValue
    @Column(name = "healthId",unique = true,nullable = false)
    private BigInteger id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
	private Customer customer;
    @Enumerated(EnumType.STRING)
    private HealthCareNeeds healtcareNeeds;
    private Boolean isSmoker;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(name = "HealtData_Disease",joinColumns = @JoinColumn(name = "healthId"),inverseJoinColumns = @JoinColumn(name = "diseaseId"))
    private List<Disease> diseases;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(name = "HealthData_Medication",joinColumns = @JoinColumn(name = "healthId"),inverseJoinColumns = @JoinColumn(name = "medicationId"))
    private List<Medication> medications;

    public HealthData() {
        super();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HealthCareNeeds getHealtcareNeeds() {
        return healtcareNeeds;
    }

    public void setHealtcareNeeds(HealthCareNeeds healtcareNeeds) {
        this.healtcareNeeds = healtcareNeeds;
    }

    public Boolean getSmoker() {
        return isSmoker;
    }

    public void setSmoker(Boolean smoker) {
        isSmoker = smoker;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public HealthData(Customer customer, HealthCareNeeds healtcareNeeds, Boolean isSmoker, List<Disease> diseases, List<Medication> medications) {
        this.customer = customer;
        this.healtcareNeeds = healtcareNeeds;
        this.isSmoker = isSmoker;
        this.diseases = diseases;
        this.medications = medications;
    }
}
