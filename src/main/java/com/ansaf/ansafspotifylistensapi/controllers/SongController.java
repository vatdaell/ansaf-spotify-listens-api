package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.Song;
import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/songs")
public class SongController {

    @Autowired
    private SongsRepository songsRepository;

    @GetMapping
    public @ResponseBody List<Song> index(){
        return songsRepository.findAll();
    }

    @GetMapping(path="/track/{track}")
    public  @ResponseBody
    List<Song> findByTrack(@PathVariable String track){
        return songsRepository.findByTrack(track);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Song> getUserById(@PathVariable String id) {
        return songsRepository.findBySpotifyTrackId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
