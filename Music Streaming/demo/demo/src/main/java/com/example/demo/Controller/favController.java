package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.favEntity;
import com.example.demo.Service.favService;

@Controller
public class favController {
    
    @Autowired
    private favService service;

    @GetMapping("/admin/fav-database")
    public String favViewPage(Model model) {
        List<favEntity> favList = service.findAll();
        model.addAttribute("favList", favList);
        return "admin/fav-database";
    }
}
