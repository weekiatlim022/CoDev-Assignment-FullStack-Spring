package com.developer.springbootbackend.service;

import com.developer.springbootbackend.entities.Country;
import com.developer.springbootbackend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country getRandomCountry() {
        return countryRepository.getRandomCountry();
    }
}
