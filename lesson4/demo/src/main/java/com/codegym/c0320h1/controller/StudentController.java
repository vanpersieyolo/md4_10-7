package com.codegym.c0320h1.controller;

import com.codegym.c0320h1.model.Student;
import com.codegym.c0320h1.model.StudentForm;
import com.codegym.c0320h1.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private Environment environment;

    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ModelAndView index(){

        ModelAndView mav = new ModelAndView("student/list");
        mav.addObject("list", studentService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("student/edit");
        mav.addObject("student", studentService.findById(id));
        return mav;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("student", student);
        studentService.update(student);
        modelAndView.addObject("mess", "done edit");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new StudentForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute StudentForm studentForm){
        //1 gan student nhung thuoc tinh cua studentForm
        Student student = new Student(studentForm.getName(), studentForm.getAddress());
        MultipartFile file = studentForm.getImage();
        String image = file.getOriginalFilename();
        student.setImage(image);
        String fileUpload = environment.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentService.save(student);
        return new ModelAndView("/student/create", "student", new StudentForm());

    }
}
