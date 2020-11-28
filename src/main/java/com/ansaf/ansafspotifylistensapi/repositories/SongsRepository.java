package com.ansaf.ansafspotifylistensapi.repositories;

import com.ansaf.ansafspotifylistensapi.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface SongsRepository extends JpaRepository<Song, Integer>, JpaSpecificationExecutor<Song> {
    Optional<List<Song>> findByTrack(String track);
    Optional<Song> findBySpotifyTrackId(String id);
}