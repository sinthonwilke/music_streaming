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

    @GetMapping("/admin/genre-database/find")
    public String findGenre(Model model, @Param("id") Long id, @Param("name") String name) {
        if(id != null && name == "") {
            genreEntity genre = service.findByID(id);
            model.addAttribute("genres", genre);
            model.addAttribute("id", id);
            model.addAttribute("name", name);
            return "admin/genre-database";
        }
        List<genreEntity> genre = service.findByAllColumn(id, name);
        model.addAttribute("genres", genre);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "admin/genre-database";
    }

    @GetMapping("/admin/genre-database/add")
    public String addGenre(Model model) {
        model.addAttribute("genre", new genreEntity());
        model.addAttribute("pageMessage", "Add new music");
        model.addAttribute("is_required", "");
        return "admin/genre-database-form";
    }

    @PostMapping("/admin/genre-database/save")
    public String SaveGenre(genreEntity genre, RedirectAttributes ra) {
        service.save(genre);
        ra.addFlashAttribute("pageMessage", "Genre id:" + genre.getId() + " has been saved."); 
        return "redirect:/admin/genre-database";
    }

    @GetMapping("/admin/genre-database/edit-id-{id}")
    public String editGenre(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            genreEntity genre = service.findByID(id);
            model.addAttribute("genre", genre);
            model.addAttribute("pageMessage", "Edit genre id:" + id);
            return "admin/genre-database-form";
        }
        catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("pageMessage", e.getMessage());
            return "redirect:/admin/genre-database";
        }
    }
}
