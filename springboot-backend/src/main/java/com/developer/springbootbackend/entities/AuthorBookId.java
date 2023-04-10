package com.developer.springbootbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Embeddable
public class AuthorBookId implements Serializable {
    @Column(name = "author_id")
    private Integer author;

    @Column(name = "book_id")
    private Integer book;
}
