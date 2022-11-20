package com.example.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.user.userDetail;
import com.example.demo.user.userEntity;

@Controller
public class mainController {

    //example
    @GetMapping("/example")
    public String examplePage() {        
        return "example";
    }


    //user
    @GetMapping("/")
    public String homePage(Model model, @AuthenticationPrincipal userDetail user) {      
        return "user/home";
    }
    @GetMapping("/search")
    public String searchPage(Model model, @AuthenticationPrincipal userDetail user) {
        return "user/search";
    }
    @GetMapping("/library")
    public String libraryPage(Model model, @AuthenticationPrincipal userDetail user) {
        return "user/library";
    }
    @GetMapping("/account")
    public String accountPage(Model model, @AuthenticationPrincipal userDetail user) {
        model.addAttribute("userEmail", user.getUsername());
        model.addAttribute("userId", user.getId());
        return "user/account";
    }


    //login & registration
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new userEntity());
        return "user/register";
    }


    //admin
    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
    } 

}
