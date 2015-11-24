package com.manager.labo.dao.impl;

import com.manager.labo.dao.ExaminationDetailsDao;
import com.manager.labo.entities.ExaminationDetails;
import org.springframework.stereotype.Repository;

/**
 * @author Piotr
 */
@Repository("examinationDetailsDao")
public class ExaminationDetailsDaoImpl extends GenericDAOImpl<ExaminationDetails> implements ExaminationDetailsDao {

    public ExaminationDetailsDaoImpl(){
        this(ExaminationDetails.class);
    }

    public ExaminationDetailsDaoImpl(final Class<ExaminationDetails> typeParameterClass) {
        super(typeParameterClass);
    }
}
