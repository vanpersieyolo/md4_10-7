package com.codegym.service;

import com.codegym.model.Customers;

import java.util.List;

public interface ICustomers {
    List<Customers> findAll();
    Customers findOne(Long id);
    Customers save(Customers customer);
}
