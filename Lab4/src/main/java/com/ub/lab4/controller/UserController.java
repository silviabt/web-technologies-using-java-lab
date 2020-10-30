package com.ub.lab4.controller;

import com.ub.lab4.model.User;
import com.ub.lab4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String save(@ModelAttribute User user, Model model) {
        System.out.println(String.format("Request to save user: %s", user.getUsername()));
        userService.save(user);
        model.addAttribute("user", User.builder().build());
        return "saveUser";
    }

    @GetMapping("/user")
    public String get(Model model) {
        model.addAttribute("user", User.builder().build());
        return "saveUser";
    }
}
