package com.developer.springbootbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class BookRentId implements Serializable {
    @Column(name = "person_id")
    private Integer person;
    @Column(name = "book_id")
    private Integer book;
}
