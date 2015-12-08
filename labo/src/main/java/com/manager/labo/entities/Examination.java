package com.manager.labo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Piotr
 */
@Entity
@Table(name = "examination")
public class Examination extends AbstractEntity {

    private static final long serialVersionUID = -8043237791988164236L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    @Column(name = "date", columnDefinition = "DATETIME", nullable = false)
    private Date date;

    @Column(name = "code", nullable = false, columnDefinition = "varchar(1)")
    private String code;

    @OneToMany(mappedBy = "examination", fetch = FetchType.LAZY)
    private Set<ExaminationDetails> examinationDetailses = new HashSet<>();

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(final Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public Set<ExaminationDetails> getExaminationDetailses() {
        return examinationDetailses;
    }

    public void setExaminationDetailses(final Set<ExaminationDetails> examinationDetailses) {
        this.examinationDetailses = examinationDetailses;
    }
}
