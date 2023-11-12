package com.msa.book.application.outputport;

import com.msa.book.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOutputPort {
    Book getBookById(Long bookNo);

    Book save(Book book);

}
