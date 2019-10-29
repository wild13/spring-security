package com.wildcodeschool.myProjectWithSecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping( "/" )
    public String hello() {
        return "Welcome to the SHIELD";
    }

    @GetMapping( "/avengers/assemble" )
    public String avenger() {
        return "Avengers... Assemble";
    }

    @GetMapping( "/secret-bases" )
    public List<String> secret() {
        String cities[] = new String[] { "Biarritz", "Bordeaux", "La Loupe", "Lille", "Lyon",
                "Marseille", "Nantes", "Orléans", "Paris", "Reims", "Strasbourg", "Toulouse",
                "Tours", "Amsterdam", "Barcelone", "Berlin", "Bruxelles", "Bucarest", "Budapest",
                "Dublin", "Lisbonne", "Londres", "Madrid", "Milan" };
        List<String> list = Arrays.asList( cities );
        return list;
    }

}