package com.ansaf.ansafspotifylistensapi.models;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "songs")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(notes = "The database generated song ID")
    private int id;

    @Column(name = "spotify_track_id", nullable = false)
    @ApiModelProperty(notes = "The spotify generated track ID")
    private String spotifyTrackId;

    @Column(name = "track", nullable = false)
    @ApiModelProperty(notes = "The song name")
    private String track;

    @Column(name = "artist", nullable = false)
    @ApiModelProperty(notes = "The artist name")
    private String artist;

    @Column(name = "album", nullable = false)
    @ApiModelProperty(notes = "The album name")
    private String album;

    @Column(name = "duration", nullable = false)
    @ApiModelProperty(notes = "Duration of song in milliseconds")
    private int duration;

    @Column(name = "popularity", nullable = false)
    @ApiModelProperty(notes = "Popularity of the song out of 100")
    private int popularity;

    @Column(name = "explicit", nullable = false)
    @ApiModelProperty(notes = "Label for explicit song, 1 means explicit")
    private int explicit;

    @Column(name = "lyrics")
    @ApiModelProperty(notes = "Lyrics of song")
    private String lyrics;

    @Column(name = "danceability", nullable = false)
    @ApiModelProperty(notes = "Describes how suitable a track is for dancing")
    private float danceability;

    @Column(name = "energy", nullable = false)
    @ApiModelProperty(notes = "Energy is a measure of intensity in the music")
    private float energy;

    @Column(name = "majority_key", nullable = false)
    @ApiModelProperty(notes = "The key the track is in. Integers map to pitches using standard Pitch Class")
    private float majorityKey;

    @Column(name = "loudness", nullable = false)
    @ApiModelProperty(notes = "The overall loudness of a track in decibels (dB)")
    private float loudness;

    @Column(name = "mode", nullable = false)
    @ApiModelProperty(notes = "Mode indicates the modality (major or minor) of a track")
    private float mode;

    @Column(name = "speechiness", nullable = false)
    @ApiModelProperty(notes = "Speechiness detects the presence of spoken words in a track")
    private float speechiness;

    @Column(name = "acousticness", nullable = false)
    @ApiModelProperty(notes = "A confidence measure of whether the track is acoustic")
    private float acousticness;

    @Column(name = "instrumentalness", nullable = false)
    @ApiModelProperty(notes = "Predicts whether a track contains no vocals")
    private float instrumentalness;

    @Column(name = "liveness", nullable = false)
    @ApiModelProperty(notes = "Detects the presence of an audience in the recording")
    private float liveness;

    @Column(name = "valence", nullable = false)
    @ApiModelProperty(notes = "A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track")
    private float valence;

    @Column(name = "tempo", nullable = false)
    @ApiModelProperty(notes = "The overall estimated tempo of a track in beats per minute (BPM)")
    private float tempo;

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
