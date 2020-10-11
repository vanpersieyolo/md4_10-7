package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.customerService.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/student")
    public String home(Model model){
        Iterable<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "home";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("student", new Student());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/student";
    }
    @GetMapping("/delete/id={id}")
    public String delete(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/student";
    }

}
