package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {

        if (id == 1){
            return new Post(1L, "A new Post", "this is a brilliant post. 10/10");
        }else{
            return null;
        }
    }

    @PostMapping
    private void createPost(Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }
}
