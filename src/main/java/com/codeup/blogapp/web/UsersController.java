package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    List<Post> posts = new ArrayList<>(){{
        add(new Post(1L, "a new post", "This is a brilliant post 10/10", null, null));
        add(new Post(1L, "a newer post", "This is a slightly more brilliant post 10/10", null, null));
        add(new Post(1L, "a new post", "This is a supremely brilliant post 10/10", null,  null));

    }};


    List<User> users = new ArrayList<>() {{

        add(new User(1L, "stephen.nguyen15", "stephen.nguyen15@yahoo.com", "password", User.Role.USER, posts));
        add(new User(1L, "stephen.nguyen15", "stephen.nguyen15@yahoo.com", "password", User.Role.USER, posts));
        add(new User(1L, "stephen.nguyen15", "stephen.nguyen15@yahoo.com", "password", User.Role.USER, posts));

    }};

    @GetMapping
    private List<User> getUsers() {
        return users;
    }

    @GetMapping("{id}")
    private User getUserById(@PathVariable Long id) {
        if (id == 1) {
            return new User(1L, "stephen.nguyen15", "stephen.nguyen15@yahoo.com", "password", User.Role.USER, posts);
        }
        return null;
    }

    @GetMapping("/findByUsername")
    private User getByUsername(@RequestParam String username) {
        if (username.equals("stephen.nguyen15")) {
            return new User(1L, "stephen.nguyen15", "stephen.nguyen15@yahoo.com", "password", User.Role.USER, posts);
        }
        return null;
    }

    @GetMapping("/findByEmail")
    private User getByEmail(@RequestParam String email) {
        if (email.equals("stephen.nguyen15@yahoo.com")) {
            return new User(1L, "stephen.nguyen15", "stephen.nguyen15@yahoo.com", "password", User.Role.USER, posts);
        }
        return null;
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
    }

    @PutMapping({"/{id}"})
    private void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(user.getUsername());
    }

    @PutMapping({"/{id}/updatePassword"})
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                if (Objects.equals(user.getPassword(), oldPassword))
                    user.setPassword(newPassword);
                System.out.println(newPassword);
            }
        }
    }

    @DeleteMapping({"{id}"})
    private void deleteUser(@PathVariable Long id){
        System.out.println("This id has been deleted: " + id);

    }

}
