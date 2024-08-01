package com.nhung.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${student.name}")
    private String studentName;
    @Value("${student.age}")
    private String studentAge;
    @Value("${teacher.name}")
    private String teacherName;
    @Value("${teacher.age}")
    private String teacherAge;


    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/learning")
    public String dailyLearning() {
        return "Let's learn Spring Boot";
    }

    @GetMapping("/fortune")
    public String dailyFortune() {
        return "Today is your lucky day";
    }

    @GetMapping("/courseinfo")
    public String courseInfo() {
        return "This is the course info\n" +
                "Student name: " + studentName + "\n"
                + "Student age: " + studentAge + "\n"
                + "Teacher name: "+ teacherName +"\n"
                + "Teacher age: " + teacherAge + "\n";
    }
}
