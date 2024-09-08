package com.nhung.thymeleafdemo.controller;

import com.nhung.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programming_languages}")
    private List<String> programmingLanguages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/studentForm")
    public String showForm(Model theModel) {

        // create student object
        Student theStudent = new Student();
        // add student object to the model
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("programmingLanguages", programmingLanguages);
        theModel.addAttribute("systems", systems);

        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("First Name : " + theStudent.getFirstName());
        System.out.println("Last Name : " + theStudent.getLastName());

        return "processStudentForm";
    }
}
