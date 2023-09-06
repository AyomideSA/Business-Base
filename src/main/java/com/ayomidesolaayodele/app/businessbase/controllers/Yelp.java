package com.ayomidesolaayodele.app.businessbase.controllers;

import com.ayomidesolaayodele.app.businessbase.services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Yelp {

    @Autowired
    YelpService yelpService;

    @GetMapping("/")
    public ResponseEntity<String> getRestaurants(String location, String type, Integer amount) throws IOException {
        location = "NYC";
        type = "Sushi";
        amount = 1;
        return yelpService.getRestaurantsByLocation(location, type, amount);
    }

}
