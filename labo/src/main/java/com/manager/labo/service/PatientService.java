package com.manager.labo.service;

import com.manager.labo.entities.Patient;
import com.manager.labo.model.PatientModel;

/**
 * @author pszerszen
 */
public interface PatientService extends AbstractService<PatientModel> {
    
    Long create(PatientModel model);
    
    Patient update(PatientModel model);
    
    Patient get(Long id);
    
    Patient getByPesel(String pesel);
    
    PatientModel getPatientModelByPesel(String pesel);

}
