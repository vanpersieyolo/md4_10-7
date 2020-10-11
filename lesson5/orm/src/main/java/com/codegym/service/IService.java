package com.codegym.service;

public interface IService<T> {
    Iterable<T> findAll();
    T findById(int id);
    T save(T t);
    T delete(int id);
}
