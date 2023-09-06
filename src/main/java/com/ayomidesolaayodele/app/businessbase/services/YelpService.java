package com.ayomidesolaayodele.app.businessbase.services;

import com.ayomidesolaayodele.app.businessbase.models.YelpAuthorization;
import com.ayomidesolaayodele.app.businessbase.repositories.YelpAuthorizationRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class YelpService {

    YelpAuthorizationRepository yelpAuthorizationRepository;

    private static final String API_HOST = "api.yelp.com";

    private static final String BUSINESS_SEARCH_PATH = "/v3/businesses/search";

    public YelpService(YelpAuthorizationRepository yelpAuthorizationRepository) {
        this.yelpAuthorizationRepository = yelpAuthorizationRepository;
    }

    public ResponseEntity<String> getRestaurantsByLocation(String location, String type, int amount) throws IOException {
        Optional<YelpAuthorization> yelpAuthorization = yelpAuthorizationRepository.findById("1");
        String client_secret = yelpAuthorization.get().getApi_key();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + client_secret);
        headers.add("accept", "application/json");
        String url = "https://" + API_HOST + BUSINESS_SEARCH_PATH + "?location=" + location + "&term=" + type + "&sort_by=best_match&limit=" + amount;
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(Objects.requireNonNull(response.getBody()));
        String prettyJsonString = gson.toJson(je);

        return response;
    }

}
