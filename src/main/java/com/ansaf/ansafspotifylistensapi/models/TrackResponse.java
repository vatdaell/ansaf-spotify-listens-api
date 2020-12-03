package com.ansaf.ansafspotifylistensapi.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Version;
import java.io.Serializable;

public class TrackResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Song Model is returned")
    private Song song;

    @Version
    @ApiModelProperty(notes = "Model Version")
    private String version;

    @ApiModelProperty(notes = "Url of endpoint")
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
