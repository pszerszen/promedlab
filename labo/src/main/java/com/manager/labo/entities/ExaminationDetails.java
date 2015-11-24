package com.manager.labo.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Piotr on 2015-11-23.
 */
@Entity
@Table(name = "examination_details")
public class ExaminationDetails extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "examinationId", nullable = false)
    private Examination examination;

    @ManyToOne
    @JoinColumn(name = "code", nullable = false, referencedColumnName = "code2")
    private Icd code;

    @Column(name = "value", nullable = false, columnDefinition = "int(11)")
    private Integer value;

    @Column(name = "staff_name", nullable = false, columnDefinition = "varchar(100")
    private String staffName;

    @Column(name = "birth", columnDefinition = "DATETIME", nullable = false)
    private Date date;

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(final Examination examination) {
        this.examination = examination;
    }

    public Icd getCode() {
        return code;
    }

    public void setCode(final Icd code) {
        this.code = code;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(final String staffName) {
        this.staffName = staffName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }
}
