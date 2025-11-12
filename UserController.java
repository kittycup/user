package com.example.userloginapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    Map<String, String> users = new HashMap<>();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (user.getPassword().length() < 6) {
            return "Password must be at least 6 characters long!";
        }
        if (users.containsKey(user.getUsername())) {
            return "Username already exists!";
        }
        users.put(user.getUsername(), user.getPassword());
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (!users.containsKey(user.getUsername())) {
            return "User not found!";
        }
        if (users.get(user.getUsername()).equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid password!";
        }
    }
}
