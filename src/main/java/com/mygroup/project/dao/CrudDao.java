package com.mygroup.project.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CrudDao<T> {

    T readById(long id);
    List<T> readAll();
    void delete(T element);
    Serializable create(T element);
    T update(T element);

}
