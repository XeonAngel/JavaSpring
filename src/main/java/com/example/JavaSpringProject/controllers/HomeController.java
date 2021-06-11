package com.example.JavaSpringProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/login")
    public String login() {
        return "Authentication/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("errorMessage", "Invalid user or password");
        return "Authentication/login";
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        return "Authentication/access-denied";
    }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }
}
