package com.ansaf.ansafspotifylistensapi.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "songs")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    public Song(){}

    public Song(Integer id, String spotifyTrackId, String track, String artist, String album, Integer duration,
                Integer popularity, Integer explicit, String lyrics, Float danceability, Float energy,
                Float majorityKey, Float loudness, Float mode, Float speechiness, Float acousticness,
                Float instrumentalness, Float liveness, Float valence, Float tempo) {
        this.id = id;
        this.spotifyTrackId = spotifyTrackId;
        this.track = track;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.popularity = popularity;
        this.explicit = explicit;
        this.lyrics = lyrics;
        this.danceability = danceability;
        this.energy = energy;
        this.majorityKey = majorityKey;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "spotify_track_id", nullable = false)
    private String spotifyTrackId;

    @Column(name = "track", nullable = false)
    private String track;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "album", nullable = false)
    private String album;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "popularity", nullable = false)
    private int popularity;

    @Column(name = "explicit", nullable = false)
    private int explicit;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "danceability", nullable = false)
    private float danceability;

    @Column(name = "energy", nullable = false)
    private float energy;

    @Column(name = "majority_key", nullable = false)
    private float majorityKey;

    @Column(name = "loudness", nullable = false)
    private float loudness;

    @Column(name = "mode", nullable = false)
    private float mode;

    @Column(name = "speechiness", nullable = false)
    private float speechiness;

    @Column(name = "acousticness", nullable = false)
    private float acousticness;

    @Column(name = "instrumentalness", nullable = false)
    private float instrumentalness;

    @Column(name = "liveness", nullable = false)
    private float liveness;

    @Column(name = "valence", nullable = false)
    private float valence;

    @Column(name = "tempo", nullable = false)
    private float tempo;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSpotifyTrackId(String spotifyTrackId) {
        this.spotifyTrackId = spotifyTrackId;
    }

    public String getSpotifyTrackId() {
        return spotifyTrackId;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTrack() {
        return track;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setExplicit(int explicit) {
        this.explicit = explicit;
    }

    public int getExplicit() {
        return explicit;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setDanceability(float danceability) {
        this.danceability = danceability;
    }

    public float getDanceability() {
        return danceability;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getEnergy() {
        return energy;
    }

    public void setMajorityKey(float majorityKey) {
        this.majorityKey = majorityKey;
    }

    public float getMajorityKey() {
        return majorityKey;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    public float getLoudness() {
        return loudness;
    }

    public void setMode(float mode) {
        this.mode = mode;
    }

    public float getMode() {
        return mode;
    }

    public void setSpeechiness(float speechiness) {
        this.speechiness = speechiness;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public void setAcousticness(float acousticness) {
        this.acousticness = acousticness;
    }

    public float getAcousticness() {
        return acousticness;
    }

    public void setInstrumentalness(float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public void setLiveness(float liveness) {
        this.liveness = liveness;
    }

    public float getLiveness() {
        return liveness;
    }

    public void setValence(float valence) {
        this.valence = valence;
    }

    public float getValence() {
        return valence;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + id + '\'' +
                "spotifyTrackId=" + spotifyTrackId + '\'' +
                "track=" + track + '\'' +
                "artist=" + artist + '\'' +
                "album=" + album + '\'' +
                "duration=" + duration + '\'' +
                "popularity=" + popularity + '\'' +
                "explicit=" + explicit + '\'' +
                "lyrics=" + lyrics + '\'' +
                "danceability=" + danceability + '\'' +
                "energy=" + energy + '\'' +
                "majorityKey=" + majorityKey + '\'' +
                "loudness=" + loudness + '\'' +
                "mode=" + mode + '\'' +
                "speechiness=" + speechiness + '\'' +
                "acousticness=" + acousticness + '\'' +
                "instrumentalness=" + instrumentalness + '\'' +
                "liveness=" + liveness + '\'' +
                "valence=" + valence + '\'' +
                "tempo=" + tempo + '\'' +
                '}';
    }
}
