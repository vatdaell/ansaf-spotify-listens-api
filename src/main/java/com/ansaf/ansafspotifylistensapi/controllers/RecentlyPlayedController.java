package com.ansaf.ansafspotifylistensapi.controllers;

import com.ansaf.ansafspotifylistensapi.models.RecentlyPlayed;
import com.ansaf.ansafspotifylistensapi.models.RecentlyPlayedResponse;
import com.ansaf.ansafspotifylistensapi.repositories.RecentlyPlayedRepository;
import com.ansaf.ansafspotifylistensapi.utils.EnvironmentHelpers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping(path = "/recently-played")
@Api(value = "Recently Played", tags = "Recently Played", description = "Operations pertaining to accessing " +
        "recently played music")
public class RecentlyPlayedController {
    @Autowired
    private RecentlyPlayedRepository recentlyPlayedRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved song"),
            @ApiResponse(code = 400, message = "Invalid Date Format, please use yyyy-mm-dd"),
            @ApiResponse(code = 401, message = "Unauthorized, please authenticate or authenticate properly"),
            @ApiResponse(code = 403, message = "Forbidden, the songs are not accessible"),
            @ApiResponse(code = 404, message = "No songs were recorded for that date")
    })
    @GetMapping(produces = "application/json")
    public @ResponseBody
    ResponseEntity<RecentlyPlayedResponse> index(@RequestParam("after") String after,
                                                 @RequestParam("before") Optional<String> before) {

        List<RecentlyPlayed> recentlyPlayed = Collections.emptyList();
        if (!dateValidator(after) || before.isPresent() && !dateValidator(before.get()))
            return ResponseEntity.badRequest().build();

        if (before.isEmpty() && dateValidator(after))
            recentlyPlayed = recentlyPlayedRepository.findAllAfterDate(after);
        else if (before.isPresent() && dateValidator(before.get()) && dateValidator(after))
            recentlyPlayed = recentlyPlayedRepository.findAllBetweenDate(after, before.get());

        if (recentlyPlayed.isEmpty())
            return ResponseEntity.notFound().build();

        RecentlyPlayedResponse response = new RecentlyPlayedResponse(
                recentlyPlayed,
                "v1",
                EnvironmentHelpers.getBaseURL() + "/recently-played/",
                after,
                recentlyPlayed.size()
        );
        return ResponseEntity.ok(response);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved song"),
            @ApiResponse(code = 400, message = "Invalid Date Format, please use yyyy-mm-dd"),
            @ApiResponse(code = 401, message = "Unauthorized, please authenticate or authenticate properly"),
            @ApiResponse(code = 403, message = "Forbidden, the songs are not accessible"),
            @ApiResponse(code = 404, message = "No songs were recorded for that date")
    })
    @GetMapping(value = "/{date}", produces = "application/json")
    public @ResponseBody
    ResponseEntity<RecentlyPlayedResponse> getSongsByDate(@PathVariable("date") String date) {

        if (!dateValidator(date))
            return ResponseEntity.badRequest().build();

        List<RecentlyPlayed> recentlyPlayedList = recentlyPlayedRepository.findAllByDate(date);

        if (recentlyPlayedList.isEmpty())
            return ResponseEntity.notFound().build();

        RecentlyPlayedResponse response = new RecentlyPlayedResponse(
                recentlyPlayedList,
                "v1",
                EnvironmentHelpers.getBaseURL() + "/recently-played/" + date,
                date,
                recentlyPlayedList.size()
        );

        return ResponseEntity.ok(response);
    }

    private boolean dateValidator(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            dateFormatter.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
