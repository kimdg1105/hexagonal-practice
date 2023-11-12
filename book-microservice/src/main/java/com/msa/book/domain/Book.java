package com.msa.book.domain;

import com.msa.book.domain.vo.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;
    private String title;
    @Embedded
    private BookDescription description;
    private Classification classification;
    private BookStatus status;
    private Location location;

    public static Book enterBook(String title,
                                 String author,
                                 String isbn,
                                 String description,
                                 LocalDate publishedDate,
                                 Classification classification,
                                 Source source,
                                 Location location) {
        BookDescription bookDescription = BookDescription.create(description, author, isbn, publishedDate, source);
        Book book = new Book();
        book.title = title;
        book.description = bookDescription;
        book.classification = classification;
        book.status = BookStatus.ENTERED;
        book.location = location;
        return book;
    }

    public Book makeAvailable() {
        this.status = BookStatus.AVAILABLE;
        return this;
    }

    public Book makeUnavailable() {
        this.status = BookStatus.UNAVAILABLE;
        return this;
    }
}
