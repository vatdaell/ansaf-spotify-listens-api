package com.ansaf.ansafspotifylistensapi.models;

import java.io.Serializable;

public class TrackResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Song song;
    private String version;
    private String url;

    public TrackResponse(String version, String url, Song song){
        this.version = version;
        this.url = url;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
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
