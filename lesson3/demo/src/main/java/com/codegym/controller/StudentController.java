package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudent;
import com.codegym.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class StudentController {
    IStudent iStudent = new StudentService();
    @GetMapping("/index")
    public String showAll(Model model){
        List<Student> students = iStudent.findAll();
        model.addAttribute("students",students);
        return "home";
    }
    @GetMapping("/student/{id}/remove")
    public String delete(@PathVariable int id){
        iStudent.remove(id);
        return"redirect:/index";
    }
    @GetMapping("/student/{id}/edit")
    public String formEdit(@PathVariable int id, Model model){
        Student student = iStudent.findById(id);
        model.addAttribute("student",student);
        return "update";
    }
    @PostMapping("/updateStudent")
    public String edit(@ModelAttribute("student") Student student){
        iStudent.edit(student);
        return "redirect:/index";
    }
    @GetMapping("/student/create")
    public String formadd(Model model){
        model.addAttribute("student",new Student());
        return "create";
    }
    @PostMapping("/create")
    public String add(Student student){
        iStudent.add(student);
        return "redirect:/index";
    }
}
