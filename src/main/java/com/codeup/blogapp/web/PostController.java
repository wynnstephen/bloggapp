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

//        return new ArrayList<Post>() {{
//            add(new Post(1L, "A new Post", "this is a brilliant post. 10/10", user, categories));
//            add(new Post(1L, "A new Post", "this is an even more brilliant post. 10/10", user, categories));
//            add(new Post(1L, "A new Post", "this is an even even more brilliant post. 10/10", user, categories));
//        }};
    }

    @GetMapping("{id}")
    public Post getPostById(@PathVariable Long id) {

        return postRepository.getById(id);

//        if (id == 1){
//            return new Post(1L, "A new Post", "this is a brilliant post. 10/10", user, categories);
//        }else{
//            return null;
//        }
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
