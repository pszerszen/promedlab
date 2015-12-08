package com.manager.labo.dao;

import com.manager.labo.entities.Patient;

/**
 * @author Piotr
 */
public interface PatientDao extends GenericDAO<Patient> {
    
    Patient getByPesel(String pesel);
}
