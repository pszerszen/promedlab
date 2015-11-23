package com.manager.labo.entites;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Piotr on 2015-11-23.
 */
@Entity
@Table(name = "examination")
public class Examination extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    @Column(name = "birth", columnDefinition = "DATETIME", nullable = false)
    private Date date;

    @ManyToOne
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
