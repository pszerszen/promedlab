package com.manager.labo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Piotr
 */
@Entity
@Table(name = "examination_details")
public class ExaminationDetails extends AbstractEntity {

    private static final long serialVersionUID = 6191062375609571026L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examinationId", nullable = false)
    private Examination examination;

    @Column(name = "code", nullable = false, columnDefinition = "varchar(3)")
    private String code;

    @Column(name = "value", nullable = true, columnDefinition = "int(11)")
    private Integer value;

    @Column(name = "staff_name", nullable = true, columnDefinition = "varchar(100)")
    private String staffName;

    @Column(name = "date", columnDefinition = "DATETIME", nullable = false)
    private Date date;

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(final Examination examination) {
        this.examination = examination;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
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
