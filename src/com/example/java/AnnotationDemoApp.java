package com.example.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // Read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach thecoach = context.getBean("handballCoach", Coach.class);

        // call a method on the bean
        System.out.println(thecoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(thecoach.getDailyFortune());

        // close the container
        context.close();
    }
}
