package com.manager.labo.service;

import java.util.Set;

import com.manager.labo.model.ExaminationModel;
import com.manager.labo.model.ExaminationRequestModel;

/**
 * @author pszerszen
 */
public interface ExaminationService extends AbstractService<ExaminationModel>{
    
    ExaminationRequestModel getExaminationRequestModel(Long examinationRequestId);
    
    void create(ExaminationRequestModel examinationRequestModel);
    
    void update(ExaminationRequestModel examinationRequestModel);
    
    Set<String> validate(ExaminationRequestModel model, boolean validateExamiantions) throws IllegalArgumentException, IllegalAccessException;
}
