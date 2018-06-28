package com.example.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HandballCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    public HandballCoach(){
        System.out.println(">> HandballCoach: inside the default constructor");
    }

    // define init method
    @PostConstruct
    public void domyStartupStuff(){
        System.out.println(">> HandballCoach: inside of domyStartupStuff()");
    }

    // define my destroy method
    @PreDestroy
    public void domyCleanupStuff(){
        System.out.println(">> HandballCoach: inside of domyCleanupStuff ");
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