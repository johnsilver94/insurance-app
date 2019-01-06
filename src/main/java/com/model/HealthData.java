package com.model;

import java.math.BigInteger;
import java.util.List;

import com.enums.HealthCareNeeds;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "HealthData")
public class HealthData {
    @Id
    @GeneratedValue
    @Column(name = "id",unique = true,nullable = false)
    private BigInteger id;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
	private Customer customer;
    private String healthId;
    @Enumerated(EnumType.STRING)
    private HealthCareNeeds healtcareNeeds;
    private Boolean smoker;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(name = "HealtData_Disease",joinColumns = @JoinColumn(name = "healthId"),inverseJoinColumns = @JoinColumn(name = "diseaseId"))
    private List<Disease> diseases;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(name = "HealthData_Medication",joinColumns = @JoinColumn(name = "healthId"),inverseJoinColumns = @JoinColumn(name = "medicationId"))
    private List<Medication> medications;

    //Getters
    @XmlAttribute
    public BigInteger getId() {
        return id;
    }
    @XmlAttribute
    public Customer getCustomer() {
        return customer;
    }
    @XmlAttribute
    public String getHealthId() {
        return healthId;
    }
    @XmlAttribute
    public HealthCareNeeds getHealtcareNeeds() {
        return healtcareNeeds;
    }
    @XmlAttribute
    public Boolean getSmoker() {
        return smoker;
    }
    @XmlAttribute
    public List<Disease> getDiseases() {
        return diseases;
    }
    @XmlAttribute
    public List<Medication> getMedications() {
        return medications;
    }

    //Setters

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setHealthId(String healthId) {
        this.healthId = healthId;
    }

    public void setHealtcareNeeds(HealthCareNeeds healtcareNeeds) {
        this.healtcareNeeds = healtcareNeeds;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public HealthData() {
        super();
    }

    public HealthData(Customer customer, String healthId, HealthCareNeeds healtcareNeeds, Boolean smoker, List<Disease> diseases, List<Medication> medications) {
        this.customer = customer;
        this.healthId = healthId;
        this.healtcareNeeds = healtcareNeeds;
        this.smoker = smoker;
        this.diseases = diseases;
        this.medications = medications;
    }
}
