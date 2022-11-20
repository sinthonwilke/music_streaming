package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.playlistEntity;
import com.example.demo.Service.playlistService;

@Controller
public class playlistController {
    
    @Autowired
    private playlistService service;

    @GetMapping("/admin/playlist-database")
    public String playlistViewPage(Model model) {
        List<playlistEntity> playlist = service.findAll();
        model.addAttribute("playlist", playlist);
        return "admin/playlist-database";
    }
}
