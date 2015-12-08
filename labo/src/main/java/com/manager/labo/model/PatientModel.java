package com.manager.labo.model;

import com.manager.labo.utils.DisplayInJTable;
import com.manager.labo.utils.MappingField;
import com.manager.labo.view.components.TableModelName;

public class PatientModel {

    private Long id;

    @MappingField
    @DisplayInJTable(name = TableModelName.PATIENTS, order = 0)
    private String pesel;

    @MappingField
    @DisplayInJTable(name = TableModelName.PATIENTS, order = 1)
    private String lastName;

    @MappingField
    @DisplayInJTable(name = TableModelName.PATIENTS, order = 2)
    private String firstName;

    @MappingField
    @DisplayInJTable(name = TableModelName.PATIENTS, order = 3)
    private String address1;

    @MappingField
    private String address2;

    @MappingField
    @DisplayInJTable(name = TableModelName.PATIENTS, order = 4)
    private String phone;

    @MappingField
    private String zipCode;

    @MappingField
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
