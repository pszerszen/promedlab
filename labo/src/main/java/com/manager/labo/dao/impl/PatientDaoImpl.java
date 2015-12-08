package com.manager.labo.dao.impl;

import org.springframework.stereotype.Repository;

import com.manager.labo.dao.PatientDao;
import com.manager.labo.entities.Patient;

/**
 * @author Piotr
 */
@Repository("patientDao")
public class PatientDaoImpl extends GenericDAOImpl<Patient> implements PatientDao {

    public PatientDaoImpl(){
        this(Patient.class);
    }

    public PatientDaoImpl(final Class<Patient> typeParameterClass) {
        super(typeParameterClass);
    }

    @Override
    public Patient getByPesel(String pesel) {
        return (Patient) getCurrentSession()
                .createQuery("FROM Patient p WHERE p.pesel = :pesel")
                .setParameter("pesel", pesel)
                .uniqueResult();
    }
}
