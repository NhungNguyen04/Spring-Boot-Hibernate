package com.nhung.springcoredemo.rest;

import com.nhung.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for dependency
    private Coach newCoach;

    // setter injection
    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach theCoach) {
        newCoach = theCoach;

    }

    @GetMapping("/dailyWorkout")
    public String dailyWorkout() {
        return newCoach.getDailyWorkout();
    }


}
