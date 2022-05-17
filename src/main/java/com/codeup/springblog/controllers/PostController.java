package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


//
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
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "post/index";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getById(id));
        return "post/show";
    }

    @GetMapping("/create")
    public String createPost(){
        return "post/create";
    }


    @PostMapping("/create")
    public String addPost(@RequestParam(name = "title")String title,@RequestParam(name="body")String body){
        Post post = new Post(title,body);
        postDao.save(post);
        return "redirect:/post";
    }



}
