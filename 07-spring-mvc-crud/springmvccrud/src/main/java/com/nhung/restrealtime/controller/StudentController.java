package com.nhung.restrealtime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/students")
    public String students(Model model) {

        return "getStudents";
    }
}
