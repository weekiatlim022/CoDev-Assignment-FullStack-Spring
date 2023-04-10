package com.developer.springbootbackend.controller;

import com.developer.springbootbackend.dto.Top3RentedBookDTO;
import com.developer.springbootbackend.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getTop3ReadBooks")
    public ResponseEntity<?> top3persons(@RequestParam(value="country_code", defaultValue="SG") String countryCode) throws JsonProcessingException {
        if (!isValidCountryCode(countryCode)) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "invalid parameter"));
        }

        List<Map<String, Object>> resultList = new ArrayList<>();
        List<Top3RentedBookDTO> result = bookService.getTop3RentedBooksAndPeopleGlobally();
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "no results"));
        }
        for (Top3RentedBookDTO dto : result) {
            Map<String, Object> map = new HashMap<>();
            map.put("book_name", dto.getBookName());
            map.put("author_name", dto.getAuthorName());
            map.put("borrowers", dto.getTop3People());
            resultList.add(map);
        }

        String json = new ObjectMapper().writeValueAsString(resultList);
        return ResponseEntity.ok(json);
    }

    private boolean isValidCountryCode(String countryCode) {
        List<String> validCodes = Arrays.asList("SG", "US", "MY", "UK");
        return validCodes.contains(countryCode);
    }
}
