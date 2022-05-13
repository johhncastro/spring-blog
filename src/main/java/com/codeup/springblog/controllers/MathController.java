package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add100to/{number}", method = RequestMethod.GET) // this is what @GetMapping does under the hood
//    // this is how you can use get mapping without using @GetMapping
    @ResponseBody
    public String addOneHundred(@PathVariable int number) {
        return number + " plus one hundred is " + (number + 100);
    }

    @RequestMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return num1 + " + " + num2 + " = " + (num1+num2) ;
    }

    @RequestMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1,@PathVariable int num2){
        return num1+ " - " + num2 + " = " + (num1-num2);
    }

    @RequestMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1,@PathVariable int num2){
        return  num1+ " x "+ num2+ " = "+ (num1*num2);
    }

    @RequestMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable double num1,@PathVariable double num2){
        return  num1+ " / "+ num2+ " = "+ (num1/num2);
    }

}
