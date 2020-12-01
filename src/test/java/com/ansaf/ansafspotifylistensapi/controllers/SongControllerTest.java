package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.Song;
import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        this.songs = new ArrayList<>();
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
                .andExpect(jsonPath("$.songs.size()",is(songs.size())))
                .andExpect(jsonPath("$.version").value(notNullValue()))
                .andExpect(jsonPath("$.url").value(notNullValue()));
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
                .andExpect(jsonPath("$.song.id").value(1))
                .andExpect(jsonPath("$.song.spotifyTrackId").value("trackid"))
                .andExpect(jsonPath("$.song.track").value("track"))
                .andExpect(jsonPath("$.song.artist").value("artist"))
                .andExpect(jsonPath("$.song.album").value("album"))
                .andExpect(jsonPath("$.song.duration").value(1000))
                .andExpect(jsonPath("$.song.popularity").value(50))
                .andExpect(jsonPath("$.song.explicit").value(1))
                .andExpect(jsonPath("$.song.lyrics").value("lyrics"))
                .andExpect(jsonPath("$.song.danceability").value(0.1f))
                .andExpect(jsonPath("$.song.energy").value(0.1f))
                .andExpect(jsonPath("$.song.majorityKey").value(1.0f))
                .andExpect(jsonPath("$.song.loudness").value(0.1f))
                .andExpect(jsonPath("$.song.mode").value(1f))
                .andExpect(jsonPath("$.song.speechiness").value(0.1f))
                .andExpect(jsonPath("$.song.acousticness").value(0.1f))
                .andExpect(jsonPath("$.song.liveness").value(0.1f))
                .andExpect(jsonPath("$.song.valence").value(0.1f))
                .andExpect(jsonPath("$.song.tempo").value(0.1f))
                .andExpect(jsonPath("$.version").value(notNullValue()))
                .andExpect(jsonPath("$.url").value(notNullValue()));
    }
}
