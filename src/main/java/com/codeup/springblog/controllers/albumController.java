package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/albums")
public class albumController {

    @GetMapping()
    @ResponseBody
    public String allAlbums(){
        return "this is where u would view all of the albums";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String oneAlbum(@PathVariable long id){
        return "the album you are viewing is "+ id;
    }

    // below code is to make a request to make a request to create an album
    @GetMapping("/create")
    @ResponseBody
    public String createAlbums(){
        return "this is where you will make a request to create an album once the form is submitted";
    }

}
