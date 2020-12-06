# Ansaf's Spotify Listens API

A REST API where anyone can access my spotify song library and listening data by given dates.
The site is available at 
<a href="https://ansaf-listens-api.herokuapp.com/swagger-ui.html">https://ansaf-listens-api.herokuapp.com/swagger-ui.html</a>

## Usage
There are currently 4 endpoints to use and the full documentation is located at <a href="https://ansaf-listens-api.herokuapp.com/swagger-ui.html">https://ansaf-listens-api.herokuapp.com/swagger-ui.html</a>.
The following is a quickstart guide.

#### /recently-played
```bash
# Recently played endpoint requires after get date variable of YYYY-MM-DD
curl -X GET "https://ansaf-listens-api.herokuapp.com/recently-played?after=YYYY-MM-DD" -H "accept: application/json"

# You can also add another get variable of before in the form of YYYY-MM-DD to get songs listened in between the before and after dates
curl -X GET "https://ansaf-listens-api.herokuapp.com/recently-played?after=YYYY-MM-DD&before=YYYY-MM-DD" -H "accept: application/json"
```

#### /recently-played/{date}
```bash
# Gets the songs listened to on the particular date of YYYY-MM-DD
curl -X GET "https://ansaf-listens-api.herokuapp.com/recently-played/YYYY-MM-DD" -H "accept: application/json"
```

#### /songs
```bash
# Returns all the songs
curl -X GET "https://ansaf-listens-api.herokuapp.com/songs" -H "accept: application/json"

# Returns all songs by the artist, returns all songs by Beach House in this case
curl -X GET "https://ansaf-listens-api.herokuapp.com/songs?artist=beach%20house" -H "accept: application/json"

# Returns all songs that are explicit, you can also set explicit=0 for non explicit songs only
curl -X GET "https://ansaf-listens-api.herokuapp.com/songs?explicit=1" -H "accept: application/json"

# Returns all songs by track name, in this case the track is Birds Dont Sing
curl -X GET "https://ansaf-listens-api.herokuapp.com/songs?track=birds%20dont%20sing" -H "accept: application/json"

# You can have any combination of artist, explicit or track variables
curl -X GET "https://ansaf-listens-api.herokuapp.com/songs?artist=The%20weeknd&explicit=1&track=wicked%20games" -H "accept: application/json"

```

#### /songs/{id}
```
# Returns song by spotify track id
curl -X GET "https://ansaf-listens-api.herokuapp.com/songs/4Rlo7NPApLjjoEefxzDpVG" -H "accept: application/json"
```

## License 
MIT License

Copyright (c) 2020 Ansaf Ahmad

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.