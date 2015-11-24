package com.manager.labo.dao.impl;

import com.manager.labo.dao.ExaminationDao;
import com.manager.labo.entities.Examination;
import org.springframework.stereotype.Repository;

/**
 * @author Piotr
 */
@Repository("examinationDao")
public class ExaminationDaoImpl extends GenericDAOImpl<Examination> implements ExaminationDao {

    public ExaminationDaoImpl(){
        this(Examination.class);
    }

    public ExaminationDaoImpl(final Class<Examination> typeParameterClass) {
        super(typeParameterClass);
    }
}
