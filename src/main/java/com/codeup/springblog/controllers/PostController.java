package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao,EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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

//    @GetMapping("/create")
//    public String createPost(){
//
//        return "post/create";
//    }


//    @PostMapping("/create")
//    public String addPost(@RequestParam(name = "title")String title,@RequestParam(name="body")String body){
//        User user = userDao.getById(4l);
//        Post post = new Post(title,body,user);
//        postDao.save(post);
//        return "redirect:/post";
//    }
    @GetMapping("/create")
    public String viewCreatePost(Model model){
        model.addAttribute("post", new Post());
        return "post/create";
    }
    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        emailService.prepareAndSend(post,post.getTitle(),post.getBody());
        postDao.save(post);

        return "redirect:/post";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "post/edit";
    }
    @PostMapping("/{id}/edit")
    public String submitEdit(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/post";

    }

//    @PostMapping("/edit")
//    public String editPost(@RequestParam(name="title")String title, @RequestParam(name="body") String body, @RequestParam(name="id") long id) {
//        Post post = postDao.getById(id);
//        post.setTitle(title);
//        post.setBody(body);
//        postDao.save(post);
//        return "redirect:/posts/" + id;
//    }


}
