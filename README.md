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