package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostRepository;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> getPosts() {

        return postRepository.findAll();

    }

    @GetMapping("{id}")
    public Post getPostById(@PathVariable Long id) {

        return postRepository.getById(id);

    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postRepository.save(newPost);
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post postsToUpdate){

        System.out.println(postsToUpdate.getTitle());
        System.out.println(postsToUpdate.getContent());
        postRepository.save(postsToUpdate);
    }

    @DeleteMapping({"/{id}"})
    private void deletePost(@PathVariable Long id){

        System.out.println("This id has been deleted: " + id);
        postRepository.deleteById(id);
    }


}
