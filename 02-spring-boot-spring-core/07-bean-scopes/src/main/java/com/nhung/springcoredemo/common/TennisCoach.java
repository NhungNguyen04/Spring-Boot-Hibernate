package com.nhung.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Tennis Coach";
    }
}
