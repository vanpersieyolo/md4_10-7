package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class excController {
    @GetMapping("/")
    public String showView(){
        return "index";
    }
    @PostMapping
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("condiment", condiment);
        return modelAndView;
    }
}
