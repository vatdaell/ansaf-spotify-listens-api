package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.RecentlyPlayed;
import com.ansaf.ansafspotifylistensapi.repositories.RecentlyPlayedRepository;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = RecentlyPlayedController.class)
@ActiveProfiles("test-songs")
public class RecentlyPlayedControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecentlyPlayedRepository recentlyPlayedRepository;

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    private List<RecentlyPlayed> recentlyPlayedList;

    @BeforeEach
    void setUp() {
        environmentVariables.set("BASE_URL", "http://testurl.com");
        RecentlyPlayed rp = new RecentlyPlayed("trackid", "artist",
                "album", "track", Timestamp.valueOf("2020-12-02 00:00:00"));
        this.recentlyPlayedList = List.of(rp);
    }

    @Test
    void shouldReturnSongsAfterDate() throws Exception {
        given(recentlyPlayedRepository.findAllAfterDate(anyString()))
                .willReturn(this.recentlyPlayedList);
        this.mockMvc.perform(get("/recently-played").param("after", "2020-12-03"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.songs.size()", is(this.recentlyPlayedList.size())))
                .andExpect(jsonPath("$.version").value(notNullValue()))
                .andExpect(jsonPath("$.date").value(notNullValue()))
                .andExpect(jsonPath("$.url").value(notNullValue()))
                .andExpect(jsonPath("$.total").value(is(this.recentlyPlayedList.size())));

    }

    @Test
    void shouldReturnSongsBetweenDates() throws Exception {
        given(recentlyPlayedRepository.findAllBetweenDate(anyString(), anyString()))
                .willReturn(this.recentlyPlayedList);
        this.mockMvc.perform(get("/recently-played")
                .param("after", "2020-12-03").param("before", "2020-12-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.songs.size()", is(this.recentlyPlayedList.size())))
                .andExpect(jsonPath("$.version").value(notNullValue()))
                .andExpect(jsonPath("$.date").value(notNullValue()))
                .andExpect(jsonPath("$.url").value(notNullValue()))
                .andExpect(jsonPath("$.total").value(is(this.recentlyPlayedList.size())));

    }

    @Test
    void shouldReturn400InvalidAfterDate() throws Exception {
        given(recentlyPlayedRepository.findAllBetweenDate(anyString(), anyString()))
                .willReturn(this.recentlyPlayedList);
        this.mockMvc.perform(get("/recently-played")
                .param("after", "202-12-03"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400InvalidBeforeDate() throws Exception {
        given(recentlyPlayedRepository.findAllBetweenDate(anyString(), anyString()))
                .willReturn(this.recentlyPlayedList);
        this.mockMvc.perform(get("/recently-played")
                .param("after", "2020-12-03").param("before", "202-12-03"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400InvalidBeforeAfterDate() throws Exception {
        given(recentlyPlayedRepository.findAllBetweenDate(anyString(), anyString()))
                .willReturn(this.recentlyPlayedList);
        this.mockMvc.perform(get("/recently-played")
                .param("after", "202-12-03").param("before", "202-12-03"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnSongsListenedOnDate() throws Exception {
        given(recentlyPlayedRepository.findAllByDate(anyString()))
                .willReturn(this.recentlyPlayedList);
        this.mockMvc.perform(get("/recently-played/{date}", "2020-12-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.songs.size()", is(this.recentlyPlayedList.size())))
                .andExpect(jsonPath("$.version").value(notNullValue()))
                .andExpect(jsonPath("$.date").value(notNullValue()))
                .andExpect(jsonPath("$.url").value(notNullValue()))
                .andExpect(jsonPath("$.total").value(is(this.recentlyPlayedList.size())));
    }

    @Test
    void shouldReturn404IfNoSongsListenedOnDate() throws Exception {
        given(recentlyPlayedRepository.findAllByDate(anyString()))
                .willReturn(Collections.emptyList());
        this.mockMvc.perform(get("/recently-played/{date}", "2020-12-02"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn400IfDateisWrong() throws Exception {
        given(recentlyPlayedRepository.findAllByDate(anyString()))
                .willReturn(Collections.emptyList());
        this.mockMvc.perform(get("/recently-played/{date}", "200-12-02"))
                .andExpect(status().isBadRequest());
    }
}
