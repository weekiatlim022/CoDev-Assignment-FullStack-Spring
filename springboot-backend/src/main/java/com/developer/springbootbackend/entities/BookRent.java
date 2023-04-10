package com.developer.springbootbackend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(BookRentId.class)
@Table(name = "book_rents")
public class BookRent {
    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;
}
