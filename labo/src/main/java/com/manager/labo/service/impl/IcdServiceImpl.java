package com.manager.labo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.labo.dao.IcdDao;
import com.manager.labo.entities.Icd;
import com.manager.labo.service.IcdService;

/**
 * @author Piotr
 */
@Service
@Transactional
public class IcdServiceImpl implements IcdService {

    @Autowired
    private IcdDao icdDao;

    @Override
    public Icd getById(final Long id) {
        return icdDao.get(id);
    }

    @Override
    public List<Icd> getByCode1(String code) {
        return icdDao.getByCode1(code);
    }

    @Override
    public Icd getByCode2(String code) {
        return icdDao.getByCode2(code);
    }

    @Override
    public List<Icd> getAllIcds() {
        return icdDao.getAll();
    }
}
