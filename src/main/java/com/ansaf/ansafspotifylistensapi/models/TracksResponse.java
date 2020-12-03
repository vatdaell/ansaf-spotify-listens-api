package com.ansaf.ansafspotifylistensapi.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Version;
import java.io.Serializable;
import java.util.List;

public class TracksResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "List of Songs")
    private List<Song> songs;
    @Version
    @ApiModelProperty(notes = "Model Version")
    private String version;
    @ApiModelProperty(notes = "Url of endpoint")
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
