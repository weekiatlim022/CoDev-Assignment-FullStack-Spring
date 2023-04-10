package com.developer.springbootbackend.repository;

import com.developer.springbootbackend.dto.Top3RentedBookDTO;
import com.developer.springbootbackend.entities.Book;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b.name AS book_name, " +
            "ARRAY_AGG(CASE WHEN c.country_code = 'SG' THEN p.name ELSE NULL END ORDER BY br_count DESC) AS top_3_persons, " +
            "ARRAY_AGG(DISTINCT a.name) AS authors " +
            "FROM books b " +
            "JOIN author_books ab ON b.id = ab.book_id " +
            "JOIN authors a ON ab.author_id = a.id " +
            "JOIN ( " +
            "    SELECT book_id, person_id, COUNT(*) AS br_count " +
            "    FROM book_rents " +
            "    GROUP BY book_id, person_id" +
            ") br ON b.id = br.book_id " +
            "JOIN people p ON br.person_id = p.id " +
            "JOIN country c ON p.country_id = c.id " +
            "WHERE c.country_code = 'SG' " +
            "  AND br.br_count = ( " +
            "      SELECT MAX(br_count) FROM ( " +
            "          SELECT book_id, person_id, COUNT(*) AS br_count " +
            "          FROM book_rents " +
            "          GROUP BY book_id, person_id " +
            "      ) q2 " +
            "      WHERE q2.book_id = br.book_id " +
            "  ) " +
            "GROUP BY b.name " +
            "ORDER BY MAX(br_count) DESC, b.name " +
            "LIMIT 3", nativeQuery = true)
    List<Tuple> getTop3RentedBooksAndPeople();
}
