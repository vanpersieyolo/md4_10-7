package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/")
    public String getTimeByTimeZone(Model model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ha_Noi") String city){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long local_time = date.getTime() + (locale.getRawOffset()-local.getRawOffset());
        date.setTime(local_time);
        model.addAttribute("city",city);
        model.addAttribute("date",date);
        return "index";
    }
}
