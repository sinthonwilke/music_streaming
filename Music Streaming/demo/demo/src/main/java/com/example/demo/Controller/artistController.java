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

import com.example.demo.Entity.artistEntity;
import com.example.demo.Service.artistService;

@Controller
public class artistController {
    
    @Autowired
    private artistService service;

    @GetMapping("/admin/artist-database")
    public String artistViewPage(Model model) {
        List<artistEntity> artistList = service.findAll();
        model.addAttribute("artistList", artistList);
        return "admin/artist-database";
    }

    @GetMapping("/admin/artist-database/find")
    public String findArtist(Model model, @Param("id") Long id, @Param("name") String name) {
        List<artistEntity> artist = service.findByAllColumn(id, name);
        model.addAttribute("artistList", artist);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "admin/artist-database";
    }



    @GetMapping("/admin/artist-database/add")
    public String addMusic(Model model) {
        model.addAttribute("artist", new artistEntity());
        model.addAttribute("pageMessage", "Add new music");
        return "admin/artist-database-form";
    }

    @PostMapping("/admin/artist-database/save")
    public String savePost(artistEntity artist, RedirectAttributes ra) {
        service.save(artist);
        ra.addFlashAttribute("pageMessage", "Music id:" + artist.getId() + " has been saved."); 
        return "redirect:/admin/artist-database";
    }

    @GetMapping("/admin/artist-database/edit-id-{id}")
    public String editArtist(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            artistEntity artist = service.findByID(id);
            model.addAttribute("artist", artist);
            model.addAttribute("pageMessage", "Edit artist id:" + id);
            return "admin/artist-database-form";
        }
        catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("pageMessage", e.getMessage());
            return "redirect:/admin/artist-database";
        }
    }

    @GetMapping("/admin/artist-database/delete-id-{id}")
    public String deleteArtist(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteByID(id);
            ra.addFlashAttribute("pageMessage", "Artist id:" + id + " has been deleted."); 
        }
        catch (Exception e) {
            ra.addFlashAttribute("pageMessage", e.getMessage());
        }
        return "redirect:/admin/artist-database";
    }
}
