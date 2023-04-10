package com.developer.springbootbackend.dto;

import java.util.List;

public class Top3RentedBookDTO {
    private String bookName;
    private String authorName;
    private List<String> top3People;

    //Constructor
    public Top3RentedBookDTO(String bookName, String authorName, List<String> top3People) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.top3People = top3People;
    }

    //Getters
    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public List<String> getTop3People() {
        return top3People;
    }
}
