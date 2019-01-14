package com.model;

import com.enums.Gender;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue
    @Column(name = "profileId",unique = true,nullable = false)
    private BigInteger id;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;
    private String name;
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phonenumber;
    private Integer age;
    private String ssc; //Social Security Number
    private String address;
    private String work;
    private String country;

    //Getters
//    @XmlAttribute
    public Customer getCustomer() {
        return customer;
    }
    @XmlAttribute
    public String getName() {
        return name;
    }
    @XmlAttribute
    public String getSurname() {
        return surname;
    }
    @XmlAttribute
    public Date getBirthday() {
        return birthday;
    }
    @XmlAttribute
    public Gender getGender() {
        return gender;
    }
    @XmlAttribute
    public String getPhonenumber() {
        return phonenumber;
    }
    @XmlAttribute
    public String getSsc() {
        return ssc;
    }
    @XmlAttribute
    public String getAddress() {
        return address;
    }
    @XmlAttribute
    public String getWork() {
        return work;
    }
    @XmlAttribute
    public Integer getAge() {
        return age;
    }
    @XmlAttribute
    public String getCountry() {
        return country;
    }

    //Setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setSsc(String ssc) {
        this.ssc = ssc;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Profile() {
        super();
    }

    public Profile(Customer customer, String name, String surname, Date birthday, Gender gender, String phonenumber, String ssc, String address, String work) {
        this.customer = customer;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.ssc = ssc;
        this.address = address;
        this.work = work;
    }
}
