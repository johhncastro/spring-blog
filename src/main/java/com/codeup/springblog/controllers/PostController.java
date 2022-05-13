package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PostController {

    @RequestMapping()
    @ResponseBody
    public String post(){
        return "this is where you will see post";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String onePost(@PathVariable long id){
        return "the post you are viewing is "+ id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost(){
        return "this is where you will make a request to create a post once the form is submitted";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPostPost(){
        return "this is where you will make a request to create an album once the form is submitted";
    }


}
