package com.manager.labo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Piotr
 */
@Entity
@Table(name = "examination")
public class Examination extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    @Column(name = "birth", columnDefinition = "DATETIME", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code", nullable = false, referencedColumnName = "code1")
    private Icd code;

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

    public Icd getCode() {
        return code;
    }

    public void setCode(final Icd code) {
        this.code = code;
    }

    public Set<ExaminationDetails> getExaminationDetailses() {
        return examinationDetailses;
    }

    public void setExaminationDetailses(final Set<ExaminationDetails> examinationDetailses) {
        this.examinationDetailses = examinationDetailses;
    }
}
