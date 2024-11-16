package com.swanhack.swan.controllers;

import com.swanhack.swan.users.User;
import com.swanhack.swan.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepo;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @GetMapping("/logIn")
    public String showLogInForm(Model model) {
        model.addAttribute("user", new User());

        return "logIn";
    }

    @PostMapping("/registerNew")
    public String register(User user) {
        System.out.println("--------------------------------------------------------------------------------------------------------`");
        System.out.println(user.getUsername());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getPassword());
        user.setUserType(User.UserType.STUDENT);
        userRepo.save(user);

        return "index";
    }
}