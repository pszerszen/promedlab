package com.manager.labo.service.impl;

import com.manager.labo.dao.ExaminationDao;
import com.manager.labo.dao.ExaminationDetailsDao;
import com.manager.labo.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
