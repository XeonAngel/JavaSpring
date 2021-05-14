package com.example.JavaSpringProject.services.interfaces;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(Long Id);
    T save(T entity);
    void deleteById(Long Id);
}
