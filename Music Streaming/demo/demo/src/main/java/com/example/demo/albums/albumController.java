package com.example.demo.albums;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
