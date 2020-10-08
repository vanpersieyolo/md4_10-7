package com.codegym.controller;


import com.codegym.form.MyUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

@Controller
public class MyFileUploadController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == MyUploadForm.class) {
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)

    public String uploadOneFileHandler(Model model) {

        MyUploadForm myUploadForm = new MyUploadForm();

        model.addAttribute("myUploadForm", myUploadForm);


        return "uploadOneFile";

    }
}
