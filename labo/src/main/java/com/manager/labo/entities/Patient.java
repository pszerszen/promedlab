package com.manager.labo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient extends AbstractEntity {

    private static final long serialVersionUID = 2546508350350725655L;

    @Column(name = "firstname", columnDefinition = "varchar(100)", nullable = false)
    private String firstName;

    @Column(name = "lastname", columnDefinition = "varchar(100)", nullable = false)
    private String lastName;

    @Column(name = "pesel", columnDefinition = "varchar(11)", nullable = true, unique = true)
    private String pesel;

    @Column(name = "address1", columnDefinition = "varchar(100)", nullable = false)
    private String address1;

    @Column(name = "address2", columnDefinition = "varchar(100)", nullable = true)
    private String address2;

    @Column(name = "city", columnDefinition = "varchar(100)", nullable = false)
    private String city;

    @Column(name = "zipCode", columnDefinition = "varchar(20)", nullable = false)
    private String zipCode;

    @Column(name = "phone", columnDefinition = "varchar(20)", nullable = false)
    private String phone;

    @Column(name = "birth", columnDefinition = "DATE", nullable = false)
    private Date birth;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Examination> examinations = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(final String pesel) {
        this.pesel = pesel;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(final String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(final String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(final Date birth) {
        this.birth = birth;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(final Set<Examination> examinations) {
        this.examinations = examinations;
    }
}
