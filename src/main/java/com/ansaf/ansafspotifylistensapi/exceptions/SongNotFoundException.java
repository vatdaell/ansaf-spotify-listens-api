package com.ansaf.ansafspotifylistensapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such song")
public class SongNotFoundException extends RuntimeException{
}
