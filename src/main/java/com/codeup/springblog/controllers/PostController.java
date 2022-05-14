package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping()
    @ResponseBody
    public String post(){
        return "this is where you will the form see post";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String onePost(@PathVariable long id){
        return "the post you are viewing is "+ id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost(){
        return "this is where the form is created to submit a form";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPostPost(){
        return "this is where you will make a request to create an album once the form is submitted";
    }


}
