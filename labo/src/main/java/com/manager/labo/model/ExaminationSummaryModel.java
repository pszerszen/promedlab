package com.manager.labo.model;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.manager.labo.utils.DisplayInJTable;
import com.manager.labo.view.components.TableModelName;

public class ExaminationSummaryModel {

    private Long id;

    @Pattern(regexp = "[A-Z]{1}\\d{2}")
    @DisplayInJTable(name = TableModelName.EXAMINATIONS_SET, order = 0)
    private String code;

    @DisplayInJTable(name = TableModelName.EXAMINATIONS_SET, order = 1)
    private String description;

    @DisplayInJTable(name = TableModelName.EXAMINATIONS_SET, order = 2)
    private String staffName;

    @DisplayInJTable(name = TableModelName.EXAMINATIONS_SET, order = 3)
    private int value;

    public ExaminationSummaryModel() {}

    public ExaminationSummaryModel(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ExaminationSummaryModel(Long id, String code, String description, String staffName, int value) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.staffName = staffName;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getValue() {
        return value;
    }

    public void setStaffNameAndValue(String staffName, int value) {
        setStaffName(staffName);
        setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(code)
                .append(description)
                .append(staffName)
                .append(value)
                .build();
    }

}
