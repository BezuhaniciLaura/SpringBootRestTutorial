package com.tutorial.spb.rest.controlers;

import com.tutorial.spb.rest.entities.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final Greeting greeting;



    public GreetingController(Greeting greeting){
        this.greeting = greeting;
    }


    @GetMapping
    String getName(){
        return greeting.getName();
    }

    @GetMapping("/coffee")
     String getCoffee(){
        return greeting.getCoffee();
    }

   /* @Value("${greeting-name}")
    private String name;

    @Value("${greeting-coffee}")
    private String drinkingCoffee;


    @GetMapping
    String getName(){
        return name;
    }

    @GetMapping("/coffee")
    String getCoffee(){
        return drinkingCoffee;
    }*/


}
