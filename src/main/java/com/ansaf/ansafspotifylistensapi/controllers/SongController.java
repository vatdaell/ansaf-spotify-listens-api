package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.Song;
import com.ansaf.ansafspotifylistensapi.models.TrackResponse;
import com.ansaf.ansafspotifylistensapi.models.TracksResponse;
import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/songs")
public class SongController {

    @Autowired
    private SongsRepository songsRepository;

    @GetMapping
    public @ResponseBody ResponseEntity<TracksResponse> index(){
        List<Song> songs = songsRepository.findAll();
        TracksResponse response = new TracksResponse("v1" ,
                "http://localhost:8080/songs", songs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<TrackResponse> getTrackById(@PathVariable String id) {
        Optional<Song> song = songsRepository.findBySpotifyTrackId(id);
        if(song.isEmpty()) return ResponseEntity.notFound().build();
        TrackResponse response = new TrackResponse("v1" ,
                "http://localhost:8080/songs/id", song.get());
        return ResponseEntity.ok(response);
    }
}
