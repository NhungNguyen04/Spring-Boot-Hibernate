package com.nhung.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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
}
