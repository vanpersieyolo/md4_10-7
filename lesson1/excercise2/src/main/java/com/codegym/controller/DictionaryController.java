package com.codegym.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping(value = "/dic")
    public String showView(){
        return "dictionary";
    }
    @PostMapping(value = "/dic")
    public String translate(@RequestParam String inputword, Model model){
        String word;
        if (inputword.equals("van")){
            word = "dai ka";
            model.addAttribute("word",word);
        }else if(inputword.equals("nghia")){
            word ="gay";
            model.addAttribute("word",word);
        }else {
            word = "khong biet";
            model.addAttribute("word",word);
        }
        return"dictionary";
    }
}
