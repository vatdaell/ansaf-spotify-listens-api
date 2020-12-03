package com.ansaf.ansafspotifylistensapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ansaf.ansafspotifylistensapi.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfo(
                "Ansaf's Spotify Listening Habits",
                "An API for accessing Ansaf's spotify library and recent listens",
                "1.0",
                "Terms of Service",
                "Ansaf Ahmad",
                "MIT License",
                "https://opensource.org/licenses/MIT"
        );
    }
}