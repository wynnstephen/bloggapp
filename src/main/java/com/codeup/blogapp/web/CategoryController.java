package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoryController {

    Category category = new Category(1L, "action");

    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "action"));
        add(new Category(1L, "comedy"));
        add(new Category(1L, "historical"));

    }};

    List<Post> posts = new ArrayList<>(){{
        add(new Post(1L, "a new post", "This is a brilliant post 10/10", null, categories));
        add(new Post(1L, "a newer post", "This is a slightly more brilliant post 10/10", null, categories));
        add(new Post(1L, "a new post", "This is a supremely brilliant post 10/10", null, categories));

    }};

    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName){
        Category category = new Category(1L, "Action");
        category.setPost(posts);
        System.out.println(categoryName);
        return category;
    }

    @GetMapping
    private Category getCategory(){
        return category;
    }


}
