package com.springrest.controllers;

import com.springrest.entities.User;
import com.springrest.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final UserService userService;

    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String restAdmin(Model model) {
        User user = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        model.addAttribute("user", user);
        return "rest/admin/adminTemplate";
    }

    @GetMapping("/user")
    public String restUser(Model model) {
        User user = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        model.addAttribute("user", user);
        return "rest/user/userTemplate";
    }

    @GetMapping(value = "/denied")
    public String dangerUser() {
        return "/rest/user/denied";
    }
}
