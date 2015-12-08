package com.manager.labo.service;

import java.util.List;

import com.manager.labo.model.ExaminationModel;
import com.manager.labo.model.ExaminationRequestModel;

/**
 * @author pszerszen
 */
public interface ExaminationService {
    
    List<ExaminationModel> getExaminationModels();
    
    ExaminationRequestModel getExaminationRequestModel(Long examinationRequestId);
    
    void create(ExaminationRequestModel examinationRequestModel);
    
    void update(ExaminationRequestModel examinationRequestModel);
    
}
