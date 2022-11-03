package com.example.lab1.controller;

import com.example.lab1.entity.Post;
import com.example.lab1.entity.User;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.repo.UserRepo;
import com.example.lab1.service.PostService;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.findAll();
    }


    @GetMapping("/{id}/posts")
    public List<Post> getPostByUserId(@PathVariable long id){
        User myUser =  userService.getUserById(id);
        return myUser.getPosts();
    }

    @PostMapping("/{id}/posts")
    public String addPostById(@PathVariable long id,@RequestBody Post post){
        User myUser =  userService.getUserById(id);
        myUser.getPosts().add(post);
        userService.addUser(myUser);
        return "Successfully added post to user: "+id;
    }
}
