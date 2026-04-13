package com.mudmanblues.web.controller;

import com.mudmanblues.web.model.Song;
import com.mudmanblues.web.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // This retrieves a song by slug and renders the "song" template
    @GetMapping("/songs/{slug}")
    public String getSongBySlug(@PathVariable String slug, Model model) {

        Song song = songRepository.findBySlug(slug);

        if (song == null) {
            return "404";
        }

        model.addAttribute("song", song);
        return "song";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        Iterable<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "songs";
    }
}