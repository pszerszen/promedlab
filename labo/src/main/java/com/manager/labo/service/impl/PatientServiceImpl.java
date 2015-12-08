package com.manager.labo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.labo.dao.PatientDao;
import com.manager.labo.entities.Patient;
import com.manager.labo.service.PatientService;

/**
 * @author pszerszen
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public Long create(Patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return patientDao.merge(patient);
    }

    @Override
    public Patient get(Long id) {
        return patientDao.get(id);
    }

    @Override
    public Patient getByPesel(String pesel) {
        return patientDao.getByPesel(pesel);
    }

}
