package com.msa.book.domain;

import com.msa.book.domain.vo.BookDescription;
import com.msa.book.domain.vo.BookStatus;
import com.msa.book.domain.vo.Classification;
import com.msa.book.domain.vo.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long no;
    private String title;
    private BookDescription description;
    private Classification classification;
    private BookStatus status;
    private Location location;
}
