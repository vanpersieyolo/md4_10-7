package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IStudent {
    List<Student> findAll ();
    void add(Student student);
    void edit(Student student);
    void remove(int id);
    Student findById(int id);
}
