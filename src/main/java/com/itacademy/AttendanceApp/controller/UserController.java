package com.itacademy.AttendanceApp.controller;


import com.itacademy.AttendanceApp.entity.User;
import com.itacademy.AttendanceApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewUsers(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("listUsers", userList);
        return "index";
    }

    @PostMapping("/register")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("ourUser", user);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("ourUser") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
}
