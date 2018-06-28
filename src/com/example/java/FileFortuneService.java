package com.example.java;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

            private String fileName = "/Users/FutureOriented/IdeaProjects/spring-demo-annotations/src/com/example/java/fortune-data.txt";
            private List<String> theFortunes;

            // random number generator
            private Random myRandom = new Random();

            public FileFortuneService(){
                System.out.println(">> FileFortuneService: inside default constructor");
            }

    @PostConstruct // beeds to be executed after dependency injection is done to perform any initialization.
    public void loadTheFotunesFile(){
        System.out.println(">> FileFortuneService: inside method loadTheFotunesFile ");

                File theFile = new File(fileName);

                System.out.println("Reading fortunes from file: " + theFile);
                System.out.println("File exists: " + theFile.exists());

                // initialize array list
                theFortunes = new ArrayList<String>();

                // read fortunes from file
                try (BufferedReader br = new BufferedReader(
                        new FileReader(theFile))) {

                    String tempLine;

            while ((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(theFortunes.size());

        String tempFortune = theFortunes.get(index);

        return tempFortune;
    }
}