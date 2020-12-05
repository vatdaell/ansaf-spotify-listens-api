package com.ansaf.ansafspotifylistensapi.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "recently_played_view")
public class RecentlyPlayed implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Spotify Track ID")
    @Column(name = "spotify_track_id")
    private String spotifyTrackId;

    @ApiModelProperty(notes = "Artist")
    @Column(name = "artist", nullable = false)
    private String artist;

    @ApiModelProperty(notes = "Album name")
    @Column(name = "album", nullable = false)
    private String album;

    @ApiModelProperty(notes = "Track name")
    @Column(name = "track", nullable = false)
    private String track;

    @Id
    @ApiModelProperty(notes = "Time played at in YYYY-MM-DD HH:MM:SS")
    @Column(name = "played_at", nullable = false)
    private Timestamp playedAt;

    public RecentlyPlayed() {
    }

    public RecentlyPlayed(String spotifyTrackId, String artist, String album, String track, Timestamp playedAt) {
        this.spotifyTrackId = spotifyTrackId;
        this.artist = artist;
        this.album = album;
        this.track = track;
        this.playedAt = playedAt;
    }

    public void setSpotifyTrackId(String spotifyTrackId) {
        this.spotifyTrackId = spotifyTrackId;
    }

    public String getSpotifyTrackId() {
        return spotifyTrackId;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTrack() {
        return track;
    }

    public void setPlayedAt(Timestamp playedAt) {
        this.playedAt = playedAt;
    }

    public Timestamp getPlayedAt() {
        return playedAt;
    }

    @Override
    public String toString() {
        return "RecentlyPlayedView{" +
                "spotifyTrackId=" + spotifyTrackId + '\'' +
                "artist=" + artist + '\'' +
                "album=" + album + '\'' +
                "track=" + track + '\'' +
                "playedAt=" + playedAt + '\'' +
                '}';
    }
}
