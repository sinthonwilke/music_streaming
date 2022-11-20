package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.albumEntity;
import com.example.demo.Service.albumService;

@Controller
public class albumController {
    
    @Autowired
    private albumService service;

    @GetMapping("/admin/album-database")
    public String albumViewPage(Model model) {
        List<albumEntity> albums = service.findAll();
        model.addAttribute("albums", albums);
        return "admin/album-database";
    }
}
