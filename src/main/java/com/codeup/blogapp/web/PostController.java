package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {


    @GetMapping
    public String getPosts(){


        return Post;
    }
}
