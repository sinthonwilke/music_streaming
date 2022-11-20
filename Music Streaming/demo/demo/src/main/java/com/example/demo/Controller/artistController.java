package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.artistEntity;
import com.example.demo.Service.artistService;

@Controller
public class artistController {
    
    @Autowired
    private artistService service;

    @GetMapping("/admin/artist-database")
    public String artistViewPage(Model model) {
        List<artistEntity> artistList = service.findAll();
        model.addAttribute("artistList", artistList);
        return "admin/artist-database";
    }
}
