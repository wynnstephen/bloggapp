package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    User user = new User("person");

    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "action"));
        add(new Category(1L, "comedy"));
        add(new Category(1L, "historical"));

    }};


    @GetMapping
    private List<Post> getPosts() {
        return new ArrayList<Post>() {{
            add(new Post(1L, "A new Post", "this is a brilliant post. 10/10", user, categories));
            add(new Post(1L, "A new Post", "this is an even more brilliant post. 10/10", user, categories));
            add(new Post(1L, "A new Post", "this is an even even more brilliant post. 10/10", user, categories));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {

        if (id == 1){
            return new Post(1L, "A new Post", "this is a brilliant post. 10/10", user, categories);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());

    }

    @DeleteMapping({"/{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("This id has been deleted: " + id);
    }
}
