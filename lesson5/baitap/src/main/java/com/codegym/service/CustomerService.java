package com.codegym.service;

import com.codegym.model.Customers;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class CustomerService implements ICustomers{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customers> findAll() {
        String queryStr = "SELECT c FROM Customers AS c";
        TypedQuery<Customers> customersTypedQuery = entityManager.createQuery(queryStr, Customers.class);
        return customersTypedQuery.getResultList();
    }

    @Override
    public Customers findOne(Long id) {
        return null;
    }

    @Override
    public Customers save(Customers customer) {
        return null;
    }
}
