package com.developer.springbootbackend.service;

import com.developer.springbootbackend.dto.Top3RentedBookDTO;
import com.developer.springbootbackend.repository.BookRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Top3RentedBookDTO> getTop3RentedBooksAndPeopleGlobally() {
        List<Tuple> tuples = bookRepository.getTop3RentedBooksAndPeople();
        List<Top3RentedBookDTO> dtos = new ArrayList<>();
        for (Tuple tuple : tuples) {
            String bookName = tuple.get("book_name", String.class);
            List<String> top3People = Arrays.asList((String[]) tuple.get("top_3_persons"));
            List<String> authors = Arrays.asList((String[]) tuple.get("authors"));
            String authorName = String.join(", ", authors);
            dtos.add(new Top3RentedBookDTO(bookName, authorName, top3People));
        }
        return dtos;
    }
}
