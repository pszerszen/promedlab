package com.manager.labo.dao.impl;

import com.manager.labo.dao.IcdDao;
import com.manager.labo.entities.Icd;
import org.springframework.stereotype.Repository;

/**
 * @author Piotr
 */
@Repository("icdDao")
public class IcdDaoImpl extends GenericDAOImpl<Icd> implements IcdDao {

    public IcdDaoImpl(){
        this(Icd.class);
    }

    public IcdDaoImpl(final Class<Icd> typeParameterClass) {
        super(typeParameterClass);
    }
}
