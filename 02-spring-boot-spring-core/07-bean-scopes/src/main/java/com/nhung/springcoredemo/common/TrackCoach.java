package com.nhung.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Track Coach";
    }
}
