package com.manager.labo.service;

import com.manager.labo.dao.IcdDao;
import com.manager.labo.entities.Icd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Piotr
 */
@Service
@Transactional
public class IcdServiceImpl implements IcdService{

    @Autowired
    private IcdDao icdDao;

    @Override
    public Icd getById(final Long id) {
        return icdDao.get(id);
    }
}
