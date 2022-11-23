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

    @GetMapping("/admin/album-database/find")
    public String albumFind(Model model, @Param("id") Long id, @Param("name") String name, @Param("artist") Long artist) {
        if(id!=null && name=="" && artist==null) {
            try {
                albumEntity albums = service.findById(id);
                model.addAttribute("albums", albums);
                model.addAttribute("id", id);
                model.addAttribute("name", name);
                model.addAttribute("artist", artist);
                return "admin/album-database";
            } catch (Exception e) {}

        }
        List<albumEntity> albums = service.findByAllColumn(id, name, artist);
        model.addAttribute("albums", albums);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("artist", artist);
        return "admin/album-database";
    }

    @GetMapping("/admin/album-database/add")
    public String addMusic(Model model) {
        model.addAttribute("album", new albumEntity());
        model.addAttribute("pageMessage", "Add new album");
        return "admin/album-database-form";
    }

    @PostMapping("/admin/album-database/save")
    public String savePost(albumEntity album, RedirectAttributes ra) {
        service.save(album);
        ra.addFlashAttribute("pageMessage", "Album id:" + album.getId() + " has been saved."); 
        return "redirect:/admin/album-database";
    }

    @GetMapping("/admin/album-database/edit-id-{id}")
    public String editAlbum(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            albumEntity album = service.findById(id);
            model.addAttribute("album", album);
            model.addAttribute("pageMessage", "Edit album id:" + id);
            return "admin/album-database-form";
        }
        catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("pageMessage", e.getMessage());
            return "redirect:/admin/album-database";
        }
    }

    @GetMapping("/admin/album-database/delete-id-{id}")
    public String deleteAlbum(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteByID(id);
            ra.addFlashAttribute("pageMessage", "Album id:" + id + " has been deleted."); 
        }
        catch (Exception e) {
            ra.addFlashAttribute("pageMessage", e.getMessage());
        }
        return "redirect:/admin/album-database";
    }
}
