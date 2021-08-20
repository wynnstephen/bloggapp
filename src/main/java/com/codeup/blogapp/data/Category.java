package com.codeup.blogapp.data;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "catagories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length = 150)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Collection<Post> post;

    public Category(){

    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Post> getPost() {
        return post;
    }

    public void setPost(Collection<Post> post) {
        this.post = post;
    }
}
