package com.example.jpabeans4.demojpabeans4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloWorld helloWorld;


    @GetMapping("/func")
    public String func(){
        System.out.println(helloWorld);
        return "Scooby Doo";
    }
}
