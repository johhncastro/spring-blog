package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/hello")
class HelloController {
    private final String[] names = {"Omar", "Mateo", "Liam", "Emma", "Reem", "Sofia", "James", "Agustin", "Antonella", "Youssef", "Abigail", "Zahra"};

    @GetMapping()
    // this will display hello world
    @ResponseBody
    public String hello() {
        return "Hello world";
    }

    @GetMapping("{name}")
    // this get mapping method is kinda like a query string
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("random")
    @ResponseBody
    public String randomGreeting(){
        int rnd = new Random().nextInt(names.length);
        return "Hello "+ names[rnd]+ "!";
    }
    @GetMapping("/{name1}/{name2}")
    @ResponseBody
    public String greetTwo(@PathVariable String name1,@PathVariable String name2){
        return "hello "+ name1 + " and "+ name2 ;
    }

    @GetMapping("/{name1}/to/{name2}")
    @ResponseBody
    public String greetEachother(@PathVariable String name1, @PathVariable String name2){
        return name1 + " says hi to "+ name2;
    }

    // cleaner way to organize code
}
