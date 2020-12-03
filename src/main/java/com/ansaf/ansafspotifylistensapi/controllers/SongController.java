package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.Song;
import com.ansaf.ansafspotifylistensapi.models.TrackResponse;
import com.ansaf.ansafspotifylistensapi.models.TracksResponse;
import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/songs")
public class SongController {

    @Autowired
    private SongsRepository songsRepository;

    @GetMapping
    public @ResponseBody ResponseEntity<TracksResponse>
    index(@RequestParam("track") Optional<String> track, @RequestParam("artist") Optional<String> artist,
          @RequestParam("explicit") Optional<Integer> explicit){
        List<Song> songs = filterSongs(songsRepository.findAll(), track, artist, explicit);
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

    private List<Song> filterSongs(List<Song> songs, Optional<String> track, Optional<String> artist,
                                   Optional<Integer> explicit){
        if(track.isPresent()){
            songs = songs.stream()
                    .filter(song -> song.getTrack().equalsIgnoreCase(track.get()))
                    .collect(Collectors.toList());
        }
        if(artist.isPresent()){
            songs = songs.stream()
                    .filter(song -> song.getArtist().equalsIgnoreCase(artist.get()))
                    .collect(Collectors.toList());
        }
        if(explicit.isPresent()){
            songs = songs.stream()
                    .filter(song -> song.getExplicit() == explicit.get())
                    .collect(Collectors.toList());
        }

        return songs;
    }
}
