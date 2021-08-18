package com.codeup.blogapp.data;

import javax.management.relation.Role;

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;

    public User(Long id, String username, String email, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
