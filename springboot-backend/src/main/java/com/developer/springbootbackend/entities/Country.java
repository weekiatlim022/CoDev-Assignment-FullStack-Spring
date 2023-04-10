package com.developer.springbootbackend.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Person> people;

    public Country() {
        // default constructor required by Hibernate
    }

    public Country(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    //getters
    public Integer getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
