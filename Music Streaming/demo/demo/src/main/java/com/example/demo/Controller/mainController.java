package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.musicEntity;
import com.example.demo.Entity.userEntity;
import com.example.demo.Service.musicService;
import com.example.demo.User.userDetail;

@Controller
public class mainController {

    @Autowired private musicService musicService;

    //admin
    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
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


    //user
    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/home")
    public String homePage(Model model) {      
        return "user/home";
    }
    @GetMapping("/search")
    public String searchPage(Model model) {
        return "user/search";
    }

        @GetMapping("/search_results={str}")
        public ResponseEntity<List<musicEntity>> searchResult(@PathVariable("str") String str, Model model) {
            List <musicEntity> music = new ArrayList<musicEntity>();
            musicService.findByName(str).forEach(music::add);
            return new ResponseEntity<>(music, HttpStatus.OK);
        }


    @GetMapping("/library")
    public String libraryPage(Model model) {
        return "user/library";
    }

    @GetMapping("/account")
    public String accountPage(Model model, @AuthenticationPrincipal userDetail user) {
        model.addAttribute("userEmail", user.getUsername());
        model.addAttribute("userId", user.getId());
        return "user/account";
    }
}
