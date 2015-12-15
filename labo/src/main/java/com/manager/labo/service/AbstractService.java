package com.manager.labo.service;

import java.util.List;

public interface AbstractService<M> {

    M getById(Long id);
    
    List<M> getAll();
}
