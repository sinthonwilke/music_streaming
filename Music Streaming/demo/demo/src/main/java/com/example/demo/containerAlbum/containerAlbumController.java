package com.example.demo.containerAlbum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class containerAlbumController {
    
    @Autowired
    private containerAlbumService service;

    @GetMapping("/admin/containerAlbum-database")
    public String containerViewPage(Model model) {
        List<containerAlbumEntity> containers = service.findAll();
        model.addAttribute("containers", containers);
        return "admin/containerAlbum-database";
    }
}
