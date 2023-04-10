package com.developer.springbootbackend.controller;

import com.developer.springbootbackend.entities.Country;
import com.developer.springbootbackend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/getRandomCountry")
    public ResponseEntity<?> getRandomCountry() {
        Optional<Country> optionalCountry = Optional.ofNullable(countryService.getRandomCountry());
        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "no results"));
        }
    }
}

