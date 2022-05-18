package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
        User user = userDao.getById(2l);
        Post post = new Post(title,body,user);
        postDao.save(post);
        return "redirect:/post";
    }



}
