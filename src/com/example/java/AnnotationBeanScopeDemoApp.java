package com.example.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach thecoach = context.getBean("handballCoach", Coach.class);
        Coach alphaCoach = context.getBean("handballCoach", Coach.class);

        boolean result = (thecoach == alphaCoach);

        // print out the results
        System.out.println("\nPointing to the same object " + result);

        System.out.println("\nMemory location for theCoach " + thecoach);

        System.out.println("\nMemory location for alphaCoach " + alphaCoach);

        // close the context
        context.close();
    }
}