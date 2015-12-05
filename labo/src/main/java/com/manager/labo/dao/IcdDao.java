package com.manager.labo.dao;

import java.util.List;

import com.manager.labo.entities.Icd;

/**
 * @author Piotr
 */
public interface IcdDao extends GenericDAO<Icd> {
    
    List<Icd> getByCode1(String code);
    
    Icd getByCode2(String code);
}
