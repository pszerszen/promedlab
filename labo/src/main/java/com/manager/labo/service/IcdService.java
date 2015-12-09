package com.manager.labo.service;

import java.util.List;

import com.manager.labo.entities.Icd;

/**
 * @author Piotr
 */
public interface IcdService {

    Icd getById(Long id);
    
    List<String> getGroups();
    
    List<String> getExaminationsFromGroup(String code);
    
    List<Icd> getByCode1(String code);
    
    Icd getByCode2(String code);
    
    List<Icd> getAllIcds();
}
