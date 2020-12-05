package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.Song;
import com.ansaf.ansafspotifylistensapi.models.TrackResponse;
import com.ansaf.ansafspotifylistensapi.models.TracksResponse;
import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import com.ansaf.ansafspotifylistensapi.utils.EnvironmentHelpers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/songs")
@Api(value = "songs", tags = "Songs", description = "Operations pertaining to accessing songs from the library")
public class SongController {

    @Autowired
    private SongsRepository songsRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved song"),
            @ApiResponse(code = 401, message = "Unauthorized, please authenticate or authenticate properly"),
            @ApiResponse(code = 403, message = "Forbidden, the songs are not accessible"),
            @ApiResponse(code = 404, message = "The songs do not exist")
    })
    @GetMapping(produces = "application/json")
    public @ResponseBody
    ResponseEntity<TracksResponse>
    index(@RequestParam("track") Optional<String> track,
          @RequestParam("artist") Optional<String> artist,
          @RequestParam("explicit") Optional<Integer> explicit) {

        List<Song> songs = filterSongs(songsRepository.findAll(), track, artist, explicit);

        TracksResponse response = new TracksResponse("v1",
                EnvironmentHelpers.getBaseURL() + "/songs", songs);
        return ResponseEntity.ok(response);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved song"),
            @ApiResponse(code = 401, message = "Unauthorized, please authenticate or authenticate properly"),
            @ApiResponse(code = 403, message = "Forbidden, the song is not accessible"),
            @ApiResponse(code = 404, message = "The song does not exist")
    }
    )
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody
    ResponseEntity<TrackResponse> getTrackById(@PathVariable String id) {
        Optional<Song> song = songsRepository.findBySpotifyTrackId(id);
        if (song.isEmpty()) return ResponseEntity.notFound().build();
        TrackResponse response = new TrackResponse("v1",
                EnvironmentHelpers.getBaseURL() + "/songs/" + id, song.get());
        return ResponseEntity.ok(response);
    }


    private List<Song> filterSongs(List<Song> songs, Optional<String> track, Optional<String> artist,
                                   Optional<Integer> explicit) {
        if (track.isPresent()) {
            songs = songs.stream()
                    .filter(song -> song.getTrack().equalsIgnoreCase(track.get()))
                    .collect(Collectors.toList());
        }
        if (artist.isPresent()) {
            songs = songs.stream()
                    .filter(song -> song.getArtist().equalsIgnoreCase(artist.get()))
                    .collect(Collectors.toList());
        }
        if (explicit.isPresent()) {
            songs = songs.stream()
                    .filter(song -> song.getExplicit() == explicit.get())
                    .collect(Collectors.toList());
        }

        return songs;
    }
}
