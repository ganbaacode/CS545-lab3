package com.example.lab1.service;

import com.example.lab1.entity.Post;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepository;

    @Autowired
    private UserRepo userRepository;


}
