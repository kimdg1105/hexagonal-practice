package com.msa.book.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookDescription {
    private String description;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    private Source source;

    public static BookDescription create(String description,
                                         String author,
                                         String isbn,
                                         LocalDate publishedDate,
                                         Source source) {
        BookDescription bookDescription = new BookDescription();
        bookDescription.description = description;
        bookDescription.author = author;
        bookDescription.isbn = isbn;
        bookDescription.publishedDate = publishedDate;
        bookDescription.source = source;
        return bookDescription;
    }
}
