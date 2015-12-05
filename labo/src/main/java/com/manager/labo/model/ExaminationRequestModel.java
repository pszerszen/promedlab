package com.manager.labo.model;

import java.util.ArrayList;
import java.util.List;

import com.manager.labo.utils.MappingField;

public class ExaminationRequestModel {

    private Long examinationId;

    @MappingField
    private String firstName;

    @MappingField
    private String lastName;

    @MappingField
    private String pesel;

    @MappingField
    private String address1;

    @MappingField
    private String address2;

    @MappingField
    private String zipCode;

    @MappingField
    private String city;

    @MappingField
    private String phone;

    private List<ExaminationModel> examinations;

    public Long getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Long examinationId) {
        this.examinationId = examinationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ExaminationModel> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<ExaminationModel> examinations) {
        this.examinations = examinations;
    }
    
    public void addExamination(ExaminationModel examinationModel){
        if(examinations == null){
            examinations = new ArrayList<>();
        }
        examinations.add(examinationModel);
    }
    
    public void removeExamination(ExaminationModel examinationModel){
        if(examinations == null){
            examinations = new ArrayList<>();
        }
        examinations.remove(examinationModel);
    }
}
