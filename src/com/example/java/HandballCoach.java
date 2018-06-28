package com.example.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandballCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    public HandballCoach(){
        System.out.println(">> HandballCoach: inside the default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your Handball drop shot";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}