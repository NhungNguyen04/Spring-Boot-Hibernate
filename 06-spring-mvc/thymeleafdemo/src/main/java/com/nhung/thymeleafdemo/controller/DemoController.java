package com.nhung.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/")
    public String home(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDate.now());
        return "helloworld";
    }

    @RequestMapping("/showform")
    public String showForm() {
        return "showform";
    }

    @RequestMapping("/submit-form")
    public String submitForm() {
        return "submitform";
    }
}
