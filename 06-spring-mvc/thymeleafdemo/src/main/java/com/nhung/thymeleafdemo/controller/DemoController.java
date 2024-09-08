package com.nhung.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/submit-form-v2")
    public String submitForm2(@RequestParam("name") String studentName, Model model) {

        String result = "Yo " + studentName + "!";
        model.addAttribute("message", result);

        return "submitform";
    }
}
