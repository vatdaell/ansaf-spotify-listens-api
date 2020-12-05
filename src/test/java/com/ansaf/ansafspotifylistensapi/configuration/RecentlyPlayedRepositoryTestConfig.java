package com.ansaf.ansafspotifylistensapi.configuration;

import com.ansaf.ansafspotifylistensapi.repositories.RecentlyPlayedRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test-songs")
@Configuration
public class RecentlyPlayedRepositoryTestConfig {
    @Bean
    @Primary
    public RecentlyPlayedRepository recentlyPlayedRepository() {
        return Mockito.mock(RecentlyPlayedRepository.class);
    }
}
