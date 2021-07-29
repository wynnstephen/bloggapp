package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "accept=application/json")
public class PostController {


    @GetMapping
    private List<Post> getPosts() {
        return new ArrayList<Post>() {{
            add(new Post(1L, "A new Post", "this is a brilliant post. 10/10"));
            add(new Post(1L, "A new Post", "this is an even more brilliant post. 10/10"));
            add(new Post(1L, "A new Post", "this is an even even more brilliant post. 10/10"));
        }};
    }

//    @PostMapping
//    private void postPosts(){
//
//    }
//
//    @PostMapping
//    private void createPosts(){
//
//    }
}
