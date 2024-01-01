package com.users.controller;

import com.users.Service.ValidationService;
import com.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    ValidationService validationService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/add")
    public String insert(@ModelAttribute User user, Model model) {
        return validationService.validateUserDetails(user, model);
    }
}
