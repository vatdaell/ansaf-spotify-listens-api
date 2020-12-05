package com.ansaf.ansafspotifylistensapi.models;

import java.io.Serializable;
import java.util.List;

public class RecentlyPlayedResponse implements Serializable {
    private List<RecentlyPlayed> songs;
    private String version;
    private String url;
    private String date;
    private int total;

    public RecentlyPlayedResponse(List<RecentlyPlayed> songs, String version, String url, String date, int total) {
        this.songs = songs;
        this.version = version;
        this.url = url;
        this.date = date;
        this.total = total;
    }

    public List<RecentlyPlayed> getSongs() {
        return songs;
    }

    public void setSongs(List<RecentlyPlayed> songs) {
        this.songs = songs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
