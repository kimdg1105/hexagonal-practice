package com.msa.book.framework.jpaadapter;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.domain.Book;
import com.msa.book.framework.jpaadapter.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookJpaAdapter implements BookOutputPort {
    private final BookJpaRepository bookJpaRepository;

    @Override
    public Book getBookById(Long bookNo) {
        return findBookById(bookNo).orElseThrow(() -> new RuntimeException("book not found"));
    }

    @Override
    public Book save(Book book) {
        return bookJpaRepository.save(book);
    }

    private Optional<Book> findBookById(Long bookNo) {
        return bookJpaRepository.findById(bookNo);
    }

}
