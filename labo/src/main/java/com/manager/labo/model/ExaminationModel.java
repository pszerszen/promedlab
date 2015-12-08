package com.manager.labo.model;

import com.manager.labo.utils.DisplayInJTable;
import com.manager.labo.view.components.TableModelName;

public class ExaminationModel {

    private Long id;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 0)
    private String requestDate;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 1)
    private String code;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 2)
    private String pesel;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 3)
    private String lastName;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 4)
    private String firstName;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 5)
    private String address;

    @DisplayInJTable(name = TableModelName.REQUESTS, order = 6)
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
