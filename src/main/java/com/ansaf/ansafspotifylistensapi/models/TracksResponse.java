package com.ansaf.ansafspotifylistensapi.models;

import java.io.Serializable;
import java.util.List;

public class TracksResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Song> songs;
    private String version;
    private String url;

    public TracksResponse(String version, String url, List<Song> song){
        this.version = version;
        this.url = url;
        this.songs = song;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
