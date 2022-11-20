package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.genreEntity;
import com.example.demo.Service.genreService;

@Controller
public class genreController {
    
    @Autowired
    private genreService service;

    @GetMapping("/admin/genre-database")
    public String genreViewPage(Model model) {
        List<genreEntity> genres = service.findAll();
        model.addAttribute("genres", genres);
        return "admin/genre-database";
    }
}
