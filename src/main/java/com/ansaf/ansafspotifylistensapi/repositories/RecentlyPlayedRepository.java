package com.ansaf.ansafspotifylistensapi.repositories;

import com.ansaf.ansafspotifylistensapi.models.RecentlyPlayed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecentlyPlayedRepository extends JpaRepository<RecentlyPlayed, Void>,
        JpaSpecificationExecutor<RecentlyPlayed> {
    @Query(value = "SELECT * " +
            "FROM recently_played_view " +
            "WHERE STR_TO_DATE(played_at, '%Y-%m-%d') =:date " +
            "ORDER BY played_at DESC", nativeQuery = true)
    public List<RecentlyPlayed> findAllByDate(@Param("date") String date);

    @Query(value = "SELECT * FROM recently_played_view " +
            "WHERE STR_TO_DATE(played_at, '%Y-%m-%d') >= :after " +
            "ORDER BY played_at DESC", nativeQuery = true)
    public List<RecentlyPlayed> findAllAfterDate(@Param("after") String after);

    @Query(value = "SELECT * " +
            "FROM recently_played_view " +
            "WHERE STR_TO_DATE(played_at, '%Y-%m-%d') >= :after " +
            "AND STR_TO_DATE(played_at, '%Y-%m-%d') <= :before " +
            "ORDER BY played_at DESC", nativeQuery = true)
    public List<RecentlyPlayed> findAllBetweenDate(@Param("after") String after,
                                                   @Param("before") String before);
}
