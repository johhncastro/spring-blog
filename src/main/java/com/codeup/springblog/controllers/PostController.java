package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {


    public List<Post> generatePosts(){
        List<Post> allPosts = new ArrayList<>();
        Post post1 = new Post(1, "hello", "this is a cool world");
        Post post2 = new Post(2, "bye", "this is a 1123 world");
        Post post3 = new Post(3, "okat", "this is a 5345345 world");
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);
        return allPosts;
    }

    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts = generatePosts();
        model.addAttribute("allPosts", allPosts);
        return "post/index";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        List<Post> allPosts = generatePosts();
        Post post = null;
        for (Post allPost : allPosts) {
            if (allPost.getId() == id) {
                post = allPost;
            }
        }
        model.addAttribute("post", post);
        return "post/show";
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
