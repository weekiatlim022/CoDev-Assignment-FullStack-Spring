package com.developer.springbootbackend.repository;

import com.developer.springbootbackend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM country ORDER BY random() LIMIT 1;")
    Country getRandomCountry();
}
