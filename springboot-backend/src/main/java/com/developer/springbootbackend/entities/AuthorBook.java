package com.developer.springbootbackend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(AuthorBookId.class)
@Table(name = "author_books")
public class AuthorBook {
    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
}

