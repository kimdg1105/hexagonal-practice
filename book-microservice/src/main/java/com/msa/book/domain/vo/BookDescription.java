package com.msa.book.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDescription {
    private String description;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    private Source source;
}
