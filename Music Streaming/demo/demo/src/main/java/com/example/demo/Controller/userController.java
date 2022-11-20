package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.userEntity;
import com.example.demo.Repository.userRepository;

@Controller
public class userController {
    
    @Autowired
    private userRepository repo;


    @GetMapping("/admin/user-database")
    public String userViewPage(Model model) {
        List<userEntity> userList = repo.findAll();
        model.addAttribute("userList", userList);
        return "admin/user-database";
    }

    @PostMapping("/register/save")
    public String registerSave(userEntity user, RedirectAttributes ra) throws Exception {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setRole("USER");
            repo.save(user);
            return "user/register-success";
        }
        catch (Exception e) {
            ra.addFlashAttribute("message", user.getEmail() + " is already in use.");
            return "redirect:/register";
        }
    }
}