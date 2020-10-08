package com.codegym.controller;


import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService = new UserService();

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("login",new Login());
        return "home";
    }
    @PostMapping("/login")
    public  String login(@ModelAttribute Login login, Model model){
        User user = userService.checkLogin(login);
        if ( user == null){
            return "error";
        }else {
            model.addAttribute("user",user);
            return "info";
        }
    }
}
