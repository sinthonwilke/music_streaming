package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.containerAlbumEntity;
import com.example.demo.Service.containerAlbumService;

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

    @GetMapping("/admin/containerAlbum-database/find")
    public String findContainerAlbum(Model model, @Param("album_id") Long album_id, @Param("music_id") Long music_id) {
        List<containerAlbumEntity> containers = service.findByAllColumn(album_id, music_id);
        model.addAttribute("containers", containers);
        model.addAttribute("album_id", album_id);
        model.addAttribute("music_id", music_id);
        return "admin/containerAlbum-database";
    }

    @GetMapping("/admin/containerAlbum-database/add")
    public String addContainerAlbum(Model model) {
        model.addAttribute("containerAlbum", new containerAlbumEntity());
        model.addAttribute("pageMessage", "Add new contain");
        return "admin/containerAlbum-database-form";
    }

    @PostMapping("/admin/containerAlbum-database/save")
    public String saveContainerAlbumPost(containerAlbumEntity containerAlbum, RedirectAttributes ra) {
        service.save(containerAlbum);
        ra.addFlashAttribute("pageMessage", "Container id:" + containerAlbum.getId() + " has been saved."); 
        return "redirect:/admin/containerAlbum-database";
    }

    @GetMapping("/admin/containerAlbum-database/edit-id-{id}")
    public String editContainerAlbum(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            containerAlbumEntity containers = service.findByID(id);
            model.addAttribute("containerAlbum", containers);
            model.addAttribute("pageMessage", "Edit containers id:" + id);
            return "admin/containerAlbum-database-form";
        }
        catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("pageMessage", e.getMessage());
            return "redirect:/admin/containerAlbum-database";
        }
    }

    @GetMapping("/admin/containerAlbum-database/delete-id-{id}")
    public String deleteContainerAlbum(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteByID(id);
            ra.addFlashAttribute("pageMessage", "Container id:" + id + " has been deleted."); 
        }
        catch (Exception e) {
            ra.addFlashAttribute("pageMessage", e.getMessage());
        }
        return "redirect:/admin/containerAlbum-database";
    }

}


