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
    @PostMapping("/registerNew")
    public String register(User user) {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            return "redirect:register?error=User+already+exists";
        }
        user.setUserType(User.UserType.STUDENT);
        userRepo.save(user);
        return "index";
    }

    @GetMapping("/loginCheck")
    public String loginCheck(String username, String password){
        User user = userRepo.findByUsername(username);
        if(user == null || !user.getPassword().equals(password)){
            return "redirect:login?error=Invalid+username+or+password";
        }
        return "redirect:teacher";
    }

}