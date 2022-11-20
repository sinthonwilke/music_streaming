package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.containerPlaylistEntity;
import com.example.demo.Service.containerPlaylistService;

@Controller
public class containerPlaylistController {
    
    @Autowired
    private containerPlaylistService service;

    @GetMapping("/admin/containerPlaylist-database")
    public String containerViewPage(Model model) {
        List<containerPlaylistEntity> containers = service.findAll();
        model.addAttribute("containers", containers);
        return "admin/containerPlaylist-database";
    }
}
