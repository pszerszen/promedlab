package com.manager.labo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.labo.dao.PatientDao;
import com.manager.labo.entities.Patient;
import com.manager.labo.model.PatientModel;
import com.manager.labo.service.PatientService;
import com.manager.labo.utils.DateUtils;

/**
 * @author pszerszen
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public Long create(PatientModel model) {
        return patientDao.save(convert(model));
    }

    @Override
    public Patient update(PatientModel model) {
        return patientDao.merge(convert(model));
    }

    @Override
    public Patient get(Long id) {
        return patientDao.get(id);
    }

    @Override
    public Patient getByPesel(String pesel) {
        return patientDao.getByPesel(pesel);
    }

    @Override
    public PatientModel getPatientModelByPesel(String pesel) {
        return convert(getByPesel(pesel));
    }

    @Override
    public PatientModel getPatientModelById(Long id) {
        return convert(get(id));
    }

    @Override
    public List<PatientModel> getPatientModels() {
        return patientDao.getAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
    
    private PatientModel convert(Patient patient){
        if(patient == null){
            return null;
        }
        PatientModel model = new PatientModel();
        model.setId(patient.getId());
        model.setPesel(patient.getPesel());
        model.setBirthDay(DateUtils.fromDate(patient.getBirth()));
        model.setLastName(patient.getLastName());
        model.setFirstName(patient.getFirstName());
        model.setAddress1(patient.getAddress1());
        model.setAddress2(patient.getAddress2());
        model.setPhone(patient.getPhone());
        model.setZipCode(model.getZipCode());
        model.setCity(patient.getCity());
        
        return model;
    }
    
    private Patient convert(PatientModel model){
        Patient patient = new Patient();
        patient.setId(model.getId());
        patient.setPesel(model.getPesel());
        patient.setBirth(DateUtils.toDate(model.getBirthDay()));
        patient.setLastName(model.getLastName());
        patient.setFirstName(model.getFirstName());
        patient.setAddress1(model.getAddress1());
        patient.setAddress2(model.getAddress2());
        patient.setPhone(model.getPhone());
        patient.setZipCode(model.getZipCode());
        patient.setCity(model.getCity());
        
        return patient;
    }

}
