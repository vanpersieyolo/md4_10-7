package com.codegym.service;

import com.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudent {
    private static List<Student> studentList = new ArrayList<>();
    static{
        String name = "Hà Nội";
        studentList.add(new Student(1,"Văn",name));
        studentList.add(new Student(2,"Văn","Hà Nội"));
        studentList.add(new Student(3,"Văn","Hà Nội"));
        studentList.add(new Student(4,"Văn","Hà Nội"));
        studentList.add(new Student(5,"Văn","Hà Nội"));
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentList;
        return students;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(Student student) {
        for (Student s : studentList) {
            if (student.getId() == s.getId()){
                s.setName(student.getName());
                s.setAddress(student.getAddress());
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Student s : studentList) {
            if (s.getId() == id){
                studentList.remove(s);
                return;
            }
        }
    }

    @Override
    public Student findById(int id) {
        for (Student student: studentList) {
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
}
