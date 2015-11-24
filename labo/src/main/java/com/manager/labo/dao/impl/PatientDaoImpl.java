package com.manager.labo.dao.impl;

import com.manager.labo.dao.PatientDao;
import com.manager.labo.entities.Patient;
import org.springframework.stereotype.Repository;

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
}
