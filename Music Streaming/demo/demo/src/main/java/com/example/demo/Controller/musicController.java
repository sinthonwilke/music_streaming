package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.Entity.musicEntity;
import com.example.demo.Exception.musicNotFoundException;
import com.example.demo.Service.StorageService;
import com.example.demo.Service.musicService;
import org.springframework.ui.Model;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
public class musicController {

    @Autowired private musicService musicService;
    @Autowired private StorageService storage;

    @GetMapping("/admin/music-database")
    public String showMusicList(Model model) {
        List<musicEntity> musicList = musicService.FindAll();
        model.addAttribute("musicList", musicList);
        return "admin/music-database";
    }

    @GetMapping("/admin/music-database/find")
    public String findMusicList(Model model, @Param("id") Long id, @Param("name") String name, @Param("release") Integer release, @Param("genre") Long genre, @Param("artist") Long artist) {
        List<musicEntity> musicList = musicService.findByAllColumn(id, name, release, genre, artist);
        model.addAttribute("musicList", musicList);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("release", release);
        model.addAttribute("genre", genre);
        model.addAttribute("artist", artist);
        return "admin/music-database";
    }

    @GetMapping("/admin/music-database/add")
    public String addMusic(Model model) {
        model.addAttribute("music", new musicEntity());
        model.addAttribute("pageMessage", "Add new music");
        model.addAttribute("is_required", "");
        return "admin/music-database-form";
    }

    @PostMapping("/admin/music-database/save")
    public String SaveMusic(@RequestParam("file") MultipartFile file, musicEntity music, RedirectAttributes ra, HttpServletRequest request) {
        musicService.save(music);
        if(!file.isEmpty()) {
                storage.saveByID(file, String.valueOf(music.getId()));
        }
        ra.addFlashAttribute("pageMessage", "Music id:" + music.getId() + " has been saved."); 
        return "redirect:/admin/music-database";
    }

    @GetMapping("/admin/music-database/edit-id-{id}")
    public String editMusic(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            musicEntity music = musicService.findByID(id);
            model.addAttribute("music", music);
            model.addAttribute("pageMessage", "Edit music id:" + id);
            return "admin/music-database-form";
        }
        catch (musicNotFoundException e) {
            e.printStackTrace();
            ra.addFlashAttribute("pageMessage", e.getMessage());
            return "redirect:/admin/music-database";
        }
    }

    @GetMapping("/admin/music-database/delete-id-{id}")
    public String deleteMusic(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            musicService.deleteByID(id);
            storage.deleteByID(String.valueOf(id));
            ra.addFlashAttribute("pageMessage", "Music id:" + id + " has been deleted."); 
        }
        catch (Exception e) {
            ra.addFlashAttribute("pageMessage", e.getMessage());
        }
        return "redirect:/admin/music-database";
    }

    @GetMapping("/admin/music-database/preview-id-{id}")
    public String previewMusic(@PathVariable("id") Long id, Model model) {
        model.addAttribute("audioSrc", "/assets/musics/" + id + ".wav");
        return "admin/music-database-preview";
    }
}