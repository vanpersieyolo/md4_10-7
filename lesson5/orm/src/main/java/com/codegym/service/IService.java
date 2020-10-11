package com.codegym.service;

import com.codegym.model.Student;

public interface IService<T> {
    Iterable<T> findAll();
    T findById(int id);
    T save(T t);
    T delete(int id);
    T update (T t);
}
