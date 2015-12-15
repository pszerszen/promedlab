package com.manager.labo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.manager.labo.dao.IcdDao;
import com.manager.labo.entities.Icd;

/**
 * @author Piotr
 */
@Repository("icdDao")
public class IcdDaoImpl extends GenericDAOImpl<Icd> implements IcdDao {

    public IcdDaoImpl() {
        this(Icd.class);
    }

    public IcdDaoImpl(final Class<Icd> typeParameterClass) {
        super(typeParameterClass);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Icd> getByCode1(String code) {
        return getCurrentSession()
                .createQuery("FROM Icd i WHERE i.code1 = :code ORDER BY i.code2")
                .setParameter("code", code)
                .list();
    }

    @Override
    public Icd getByCode2(String code) {
        return (Icd) getCurrentSession()
                .createQuery("FROM Icd i WHERE i.code2 = :code")
                .setParameter("code", code)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Icd> getAll() {
        String formula = "FROM Icd i ORDER BY i.code1";
        Query query = getCurrentSession().createQuery(formula);

        return query.list();
    }

}
