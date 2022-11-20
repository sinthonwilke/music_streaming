package com.example.demo.playlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
