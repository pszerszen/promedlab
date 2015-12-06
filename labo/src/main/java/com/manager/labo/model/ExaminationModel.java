package com.manager.labo.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.manager.labo.utils.DisplayInJTable;
import com.manager.labo.view.components.TableModelName;

public class ExaminationModel {

    @DisplayInJTable(name = TableModelName.EXAMINATIONS_SET, order = 0)
    private String code;

    @DisplayInJTable(name = TableModelName.EXAMINATIONS_SET, order = 1)
    private String description;

    public ExaminationModel() {}

    public ExaminationModel(String code, String description) {
        this.code = code;
        this.description = description;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(code)
                .append(description)
                .build();
    }

}
