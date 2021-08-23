package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.CategoryRepository;
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

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;

    }
//    @GetMapping
//
//    private Category getPostsByCategory(@RequestParam String categoryName){
//        Category category = new Category(1L, "Action");
//        category.setPost(posts);
//        System.out.println(categoryName);
//        return category;
//    }

    @GetMapping
    private  List<Category> getCategory(){

        return categoryRepository.findAll();

    }


    }

