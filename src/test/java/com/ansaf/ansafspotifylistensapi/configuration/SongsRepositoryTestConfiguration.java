package com.ansaf.ansafspotifylistensapi.configuration;

import com.ansaf.ansafspotifylistensapi.repositories.SongsRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class SongsRepositoryTestConfiguration {
    @Bean
    @Primary
    public SongsRepository songsRepository() {
        return Mockito.mock(SongsRepository.class);
    }
}
