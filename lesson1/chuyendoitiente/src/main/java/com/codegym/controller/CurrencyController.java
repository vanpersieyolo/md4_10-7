package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.DELETE;

@Controller
public class CurrencyController {
    int usd ;
    @PostMapping("/index")
    public String exchange (@RequestParam("inputMoney") int input, Model model){
        usd = input/23000;
        model.addAttribute("usd",usd);
        return "index";
    }
    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }
}
