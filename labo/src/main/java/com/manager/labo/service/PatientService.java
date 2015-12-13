package com.manager.labo.service;

import java.util.List;

import com.manager.labo.entities.Patient;
import com.manager.labo.model.PatientModel;

/**
 * @author pszerszen
 */
public interface PatientService {
    
    Long create(PatientModel model);
    
    Patient update(PatientModel model);
    
    Patient get(Long id);
    
    Patient getByPesel(String pesel);
    
    PatientModel getPatientModelByPesel(String pesel);
    
    PatientModel getPatientModelById(Long id);
    
    List<PatientModel> getPatientModels();
}
