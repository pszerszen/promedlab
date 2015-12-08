package com.manager.labo.service.impl;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.labo.dao.ExaminationDao;
import com.manager.labo.dao.ExaminationDetailsDao;
import com.manager.labo.entities.Examination;
import com.manager.labo.entities.ExaminationDetails;
import com.manager.labo.entities.Patient;
import com.manager.labo.model.ExaminationModel;
import com.manager.labo.model.ExaminationRequestModel;
import com.manager.labo.model.ExaminationSummaryModel;
import com.manager.labo.service.ExaminationService;
import com.manager.labo.service.IcdService;
import com.manager.labo.service.PatientService;
import com.manager.labo.utils.DateUtils;

/**
 * @author pszerszen
 */
@Transactional
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationDao examinationDao;

    @Autowired
    private ExaminationDetailsDao examinationDetailsDao;
    
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private IcdService icdService;

    @Override
    public List<ExaminationModel> getExaminationModels() {
        return examinationDao.getAll()
                .stream()
                .map(examination -> {
                    ExaminationModel model = new ExaminationModel();
                    model.setId(examination.getId());
                    model.setCode(examination.getCode());
                    model.setRequestDate(DateUtils.fromDateTime(examination.getDate()));
                    
                    Patient patient = examination.getPatient();
                    model.setPesel(patient.getPesel());
                    model.setFirstName(patient.getFirstName());
                    model.setLastName(patient.getLastName());
                    model.setAddress(new StringJoiner(" ").add(patient.getAddress1()).add(patient.getAddress2()).toString());
                    model.setPhone(patient.getPhone());
                    
                    return model;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ExaminationRequestModel getExaminationRequestModel(Long examinationRequestId) {
        ExaminationRequestModel model = new ExaminationRequestModel();
        
        Examination examination = examinationDao.get(examinationRequestId);
        Patient patient = examination.getPatient();
        Set<ExaminationDetails> examinationDetailses = examination.getExaminationDetailses();
        
        model.setExaminationId(examination.getId());
        model.setPesel(patient.getPesel());
        model.setFirstName(patient.getFirstName());
        model.setLastName(patient.getLastName());
        model.setAddress1(patient.getAddress1());
        model.setAddress2(patient.getAddress2());
        model.setCity(patient.getCity());
        model.setZipCode(patient.getZipCode());
        model.setPhone(patient.getPhone());
        
        model.setExaminations(examinationDetailses
                .stream()
                .map(examinationDetail -> {
                    ExaminationSummaryModel summaryModel = new ExaminationSummaryModel();
                    final String code = examinationDetail.getCode();
                    summaryModel.setCode(code);
                    summaryModel.setDescription(icdService.getByCode2(code).getName2());
                    
                    return summaryModel;
                })
                .collect(Collectors.toList()));
        
        return model;
    }

    @Override
    public void create(ExaminationRequestModel examinationRequestModel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(ExaminationRequestModel examinationRequestModel) {
        // TODO Auto-generated method stub
        
    }
}
