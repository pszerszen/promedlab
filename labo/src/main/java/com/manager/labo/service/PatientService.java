package com.manager.labo.service;

import com.manager.labo.entities.Patient;

/**
 * @author pszerszen
 */
public interface PatientService {
    
    Long create(Patient patient);
    
    Patient update(Patient patient);
    
    Patient get(Long id);
    
    Patient getByPesel(String pesel);
}
