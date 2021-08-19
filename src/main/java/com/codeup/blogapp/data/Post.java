package com.codeup.blogapp.data;

import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String title;

    @Column(nullable=false)
    private String content;

    private User user;

    private Collection<Catagory> categories;


    public Post(Long id, String title, String content, User user, Collection<Catagory>) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.categories = catagories;
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public Post(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
