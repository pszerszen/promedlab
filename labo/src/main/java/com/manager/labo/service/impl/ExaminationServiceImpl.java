package com.manager.labo.service.impl;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
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
import com.manager.labo.utils.ValidDate;

/**
 * @author pszerszen
 */
@Transactional
@Service
public class ExaminationServiceImpl implements ExaminationService {
    
    private static final List<Class<?>> VALIDATING_TYPES = new ImmutableList.Builder<Class<?>>()
            .add(NotNull.class)
            .add(Pattern.class)
            .add(ValidDate.class)
            .build();

    @Autowired
    private ExaminationDao examinationDao;

    @Autowired
    private ExaminationDetailsDao examinationDetailsDao;

    @Autowired
    private PatientService patientService;

    @Autowired
    private IcdService icdService;

    @Override
    public List<ExaminationModel> getAll() {
        return examinationDao.getAll()
                .stream()
                .map(this::mapToExaminationModel)
                .collect(Collectors.toList());
    }

    @Override
    public ExaminationRequestModel getExaminationRequestModel(Long examinationRequestId) {

        Examination examination = examinationDao.get(examinationRequestId);
        return map(examination);
    }

    @Override
    public void create(ExaminationRequestModel examinationRequestModel) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(ExaminationRequestModel examinationRequestModel) {
        // TODO Auto-generated method stub

    }

    @Override
    public ExaminationModel getById(Long id) {
        return mapToExaminationModel(examinationDao.get(id));
    }
    
    public Set<String> validate(ExaminationRequestModel model) throws IllegalArgumentException, IllegalAccessException{
        Set<String> errors = Sets.newHashSet();
        
        for(Field field : model.getClass().getDeclaredFields()){
            field.setAccessible(true);
            String fieldValue = field.get(model).toString();
            
            String error = validateField(field, fieldValue);
            if(error != null){
                errors.add(error);
            }
        }
        
        return errors;
    }

    private String validateField(Field field, String fieldValue) {
        NotNull notNullAnno = field.getAnnotation(NotNull.class);
        if(notNullAnno != null && StringUtils.isNotBlank(fieldValue)){
            return notNullAnno.message();
        }
        
        Pattern patternAnno = field.getAnnotation(Pattern.class);
        if(patternAnno != null && fieldValue.matches(patternAnno.regexp())){
            return patternAnno.message();
        }
        
        ValidDate validDateAnno = field.getAnnotation(ValidDate.class);
        if(validDateAnno != null){
            try {
                LocalDateTime.parse(fieldValue, DateTimeFormatter.ofPattern(validDateAnno.dateFormat()));
            } catch (DateTimeParseException e) {
                return validDateAnno.message();
            }
        }
        
        return null;
    }
    
    private Examination map(ExaminationRequestModel model) {
        final Long id = model.getExaminationId();
        final boolean newExamination = id == null;
        
        Examination examiantion = id == null ? new Examination() : examinationDao.get(id);

        Patient patient = patientService.getByPesel(model.getPesel());
        if (patient == null) {
            patient = new Patient();
        }
        patient.setFirstName(model.getFirstName());
        patient.setLastName(model.getLastName());
        patient.setPesel(model.getPesel());
        patient.setBirth(DateUtils.toDate(model.getBirthDay()));
        patient.setAddress1(model.getAddress1());
        patient.setAddress2(Strings.emptyToNull(model.getAddress2()));
        patient.setZipCode(model.getZipCode());
        patient.setCity(model.getCity());
        patient.setPhone(model.getPhone());
        
        final Set<ExaminationDetails> examinationDetailses = examiantion.getExaminationDetailses();
        final List<ExaminationSummaryModel> examinations = model.getExaminations();
        
        // creating new examination request
        if(newExamination){
            examiantion.setDate(new Date());
            examiantion.setCode(examinations.get(0).getCode().substring(0, 1));
        }   
        examinations.forEach(examinationDetailModel -> {
            if(newExamination){
                final ExaminationDetails detail = new ExaminationDetails();
                detail.setCode(examinationDetailModel.getCode());
                detail.setDate(new Date());
                detail.setExamination(examiantion);
                
                examinationDetailses.add(detail);
            } else {
                final ExaminationDetails detail = examinationDetailses
                        .stream()
                        .filter(d -> d.getCode().equals(examinationDetailModel.getCode()))
                        .findFirst()
                        .get();
                detail.setStaffName(examinationDetailModel.getStaffName());
                detail.setValue(examinationDetailModel.getValue());
            }
        });

        return examiantion;
    }


    private ExaminationRequestModel map(Examination examination) {
        ExaminationRequestModel model = new ExaminationRequestModel();
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

    private ExaminationModel mapToExaminationModel(Examination examination) {
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
    }
}
