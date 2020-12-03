package com.ansaf.ansafspotifylistensapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class AnsafSpotifyListensApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnsafSpotifyListensApiApplication.class, args);
    }

}
