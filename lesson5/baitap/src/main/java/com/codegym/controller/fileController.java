package com.codegym.controller;

import com.codegym.model.Customers;
import com.codegym.service.CustomerService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class fileController {
    CustomerService customerService = new CustomerService();

    @GetMapping("/home")
    public String showHome(Model model){
        List<Customers> customers;
        customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "home";
    }
}
