package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.controllers.SongController;
import com.ansaf.ansafspotifylistensapi.models.Song;
import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = SongController.class)
@ActiveProfiles("test")
public class SongControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongsRepository songsRepository;

    private List<Song> songs;
    private Song song;

    @BeforeEach
    void setUp(){
        this.songs = new ArrayList<Song>();
        this.songs.add(new Song());
        this.song = new Song(1, "trackid", "track", "artist", "album", 1000,
                50, 1, "lyrics", 0.1f, 0.1f, 1f, 0.1f,
                1.0f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f);
    }

    @Test
    void shouldReturnAllSongs() throws Exception{
        given(songsRepository.findAll()).willReturn(songs);
        this.mockMvc.perform(get("/songs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(songs.size())));
    }

    @Test
    void shouldShow404TrackById() throws Exception{
        given(songsRepository.findBySpotifyTrackId(any()))
                .willReturn(Optional.empty());
        this.mockMvc.perform(get("/songs/{id}", "TestID"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnTrackById() throws Exception{
        given(songsRepository.findBySpotifyTrackId(any()))
                .willReturn(Optional.of(song));
        this.mockMvc.perform(get("/songs/{id}", "TestID"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.spotifyTrackId").value("trackid"))
                .andExpect(jsonPath("$.track").value("track"))
                .andExpect(jsonPath("$.artist").value("artist"))
                .andExpect(jsonPath("$.album").value("album"))
                .andExpect(jsonPath("$.duration").value(1000))
                .andExpect(jsonPath("$.popularity").value(50))
                .andExpect(jsonPath("$.explicit").value(1))
                .andExpect(jsonPath("$.lyrics").value("lyrics"))
                .andExpect(jsonPath("$.danceability").value(0.1f))
                .andExpect(jsonPath("$.energy").value(0.1f))
                .andExpect(jsonPath("$.majorityKey").value(1.0f))
                .andExpect(jsonPath("$.loudness").value(0.1f))
                .andExpect(jsonPath("$.mode").value(1f))
                .andExpect(jsonPath("$.speechiness").value(0.1f))
                .andExpect(jsonPath("$.acousticness").value(0.1f))
                .andExpect(jsonPath("$.liveness").value(0.1f))
                .andExpect(jsonPath("$.valence").value(0.1f))
                .andExpect(jsonPath("$.tempo").value(0.1f));
    }

    @Test
    void shouldReturnByTrack() throws Exception{
        given(songsRepository.findByTrack(any())).willReturn(songs);
        this.mockMvc.perform(get("/songs/track/${track}","track"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(songs.size())));
    }
}
