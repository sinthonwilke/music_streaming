package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.Entity.albumEntity;
import com.example.demo.Entity.containerAlbumEntity;
import com.example.demo.Entity.containerPlaylistEntity;
import com.example.demo.Entity.favEntity;
import com.example.demo.Entity.musicEntity;
import com.example.demo.Entity.playlistEntity;
import com.example.demo.Entity.userEntity;
import com.example.demo.Service.albumService;
import com.example.demo.Service.containerAlbumService;
import com.example.demo.Service.containerPlaylistService;
import com.example.demo.Service.favService;
import com.example.demo.Service.musicService;
import com.example.demo.Service.playlistService;
import com.example.demo.Service.userService;
import com.example.demo.User.userDetail;

@Controller
public class mainController {

    @Autowired private musicService musicService;
    @Autowired private albumService albumService;
    @Autowired private containerAlbumService containerAlbumService;
    @Autowired private favService favService;
    @Autowired private playlistService playlistService;
    @Autowired private containerPlaylistService containerPlaylistService;
    @Autowired private userService userService;

    //admin
    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
    } 


    //login & registration
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new userEntity());
        return "user/register";
    }


    //user
    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/home")
    public String homePage(Model model) {      
        return "user/home";
    }
    @GetMapping("/search")
    public String searchPage(Model model) {
        return "user/search";
    }

        @GetMapping("/search_results={str}")
        public ResponseEntity<List<musicEntity>> searchMusicResult(@PathVariable("str") String str) {
            char firstSign = str.charAt(0);
            if(firstSign == '@') {
                List <musicEntity> music = new ArrayList<musicEntity>();
                musicService.findByArtistName(str.substring(1)).forEach(music::add);
                return new ResponseEntity<>(music, HttpStatus.OK);
            }
            else if(firstSign == '!') {
                List <musicEntity> music = new ArrayList<musicEntity>();
                musicService.findByGenreName(str.substring(1)).forEach(music::add);
                return new ResponseEntity<>(music, HttpStatus.OK);
            }
 
            List <musicEntity> music = new ArrayList<musicEntity>();
            musicService.findByName(str).forEach(music::add);
            return new ResponseEntity<>(music, HttpStatus.OK);
        }

        @GetMapping("/search_albums={str}")
        public ResponseEntity<List<albumEntity>> searchAlbumResult(@PathVariable("str") String str) {
            List <albumEntity> album = new ArrayList<albumEntity>();
            albumService.findByName(str).forEach(album::add);
            return new ResponseEntity<>(album, HttpStatus.OK);
        }
        @GetMapping("/albums={id}")
        public ResponseEntity<List<containerAlbumEntity>> albumList(@PathVariable("id") Long id) {
            List <containerAlbumEntity> albumList = new ArrayList<containerAlbumEntity>();
            containerAlbumService.findByAlbumID(id).forEach(albumList::add);
            return new ResponseEntity<>(albumList, HttpStatus.OK);
        }


    @GetMapping("/library")
    public String libraryPage(Model model) {
        return "user/library";
    }

        @GetMapping("/library_fav")
        public ResponseEntity<List<favEntity>> libraryFav(@AuthenticationPrincipal userDetail user) {
            List <favEntity> fav = new ArrayList<favEntity>();
            favService.findByUserId(user.getId()).forEach(fav::add);
            return new ResponseEntity<>(fav, HttpStatus.OK);
        }

        @GetMapping("/library_playlist")
        public ResponseEntity<List<playlistEntity>> libraryPlaylist(@AuthenticationPrincipal userDetail user) {
            List <playlistEntity> playlist = new ArrayList<playlistEntity>();
            playlistService.findByUserId(user.getId()).forEach(playlist::add);
            return new ResponseEntity<>(playlist, HttpStatus.OK);
        }

        @GetMapping("/playlists={id}")
        public ResponseEntity<List<containerPlaylistEntity>> playlist(@PathVariable("id") Long id) {
            List <containerPlaylistEntity> playlist = new ArrayList<containerPlaylistEntity>();
            containerPlaylistService.findByPlaylistId(id).forEach(playlist::add);
            return new ResponseEntity<>(playlist, HttpStatus.OK);
        }

        @GetMapping("/addFavorite={id}")
        public ResponseEntity<favEntity> addFavorite(@AuthenticationPrincipal userDetail user, @PathVariable("id") Long id) throws Exception{
            favEntity fav = new favEntity();
            fav.setMusic(musicService.findByID(id));
            fav.setUser(userService.findByID(user.getId()));
            favService.save(fav);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }

        @GetMapping("/delFavorite={id}")
        public ResponseEntity<favEntity> delFavorite(@AuthenticationPrincipal userDetail user, @PathVariable("id") Long id) {
            favService.deleteByUserIdAndMusicId(user.getId(), id);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }

        @GetMapping("/addPlaylist={name}")
        public ResponseEntity<playlistEntity> delFavorite(@AuthenticationPrincipal userDetail user, @PathVariable("name") String name) throws Exception {
            playlistEntity playlist = new playlistEntity();
            playlist.setName(name);
            playlist.setUser(userService.findByID(user.getId()));
            playlistService.save(playlist);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }

        @GetMapping("/dellist={id}")
        public ResponseEntity<playlistEntity> dellist(@AuthenticationPrincipal userDetail user, @PathVariable("id") Long id) {
            playlistService.del(id);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }

        @GetMapping("/addMusicToPlaylist={musicID}&{playlistID}")
        public ResponseEntity<containerPlaylistEntity> add2Playlist(@AuthenticationPrincipal userDetail user, @PathVariable("musicID") Long musicID, @PathVariable("playlistID") Long playlistID) throws Exception {
            containerPlaylistEntity container = new containerPlaylistEntity();
            container.setMusic(musicService.findByID(musicID));
            container.setPlaylist(playlistService.findById(playlistID));
            containerPlaylistService.save(container);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }

        @GetMapping("/renamePlaylist={playlistID}&{rename}")
        public ResponseEntity<playlistEntity> renamePlaylist(@AuthenticationPrincipal userDetail user, @PathVariable("playlistID") Long playlistID, @PathVariable("rename") String rename) throws Exception {
            playlistEntity playlist = playlistService.findById(playlistID);
            playlist.setName(rename);
            playlistService.save(playlist);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        
    @GetMapping("/account")
    public String accountPage(Model model, @AuthenticationPrincipal userDetail user) {
        model.addAttribute("userEmail", user.getUsername());
        model.addAttribute("userId", user.getId());
        return "user/account";
    }
}
