package com.example.java;

        import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    // load spring config file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    Coach thecoach = context.getBean("handballCoach", Coach.class);
    Coach alphaCoach = context.getBean("handballCoach", Coach.class);

    boolean result = (thecoach == alphaCoach);

    // print out the results
}
