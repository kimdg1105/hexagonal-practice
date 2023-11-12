package com.msa.book.application.inputport;

import com.msa.book.application.mapper.BookMapper;
import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.AddBookUseCase;
import com.msa.book.domain.Book;
import com.msa.book.domain.vo.Classification;
import com.msa.book.domain.vo.Location;
import com.msa.book.domain.vo.Source;
import com.msa.book.framework.web.dto.BookInfoDto;
import com.msa.book.framework.web.dto.BookOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddBookInputPort implements AddBookUseCase {
    private final BookOutputPort bookOutputPort;

    private final BookMapper bookMapper;

    @Override
    public BookOutputDto addBook(BookInfoDto bookInfoDto) {
        Book book = Book.enterBook(bookInfoDto.title(),
                bookInfoDto.author(),
                bookInfoDto.description(),
                bookInfoDto.description(),
                bookInfoDto.publicationDate(),
                Classification.valueOf(bookInfoDto.classification()),
                Source.valueOf(bookInfoDto.source()),
                Location.valueOf(bookInfoDto.location())
        );
        bookOutputPort.save(book);
        return bookMapper.toBookOutputDto(book);
    }
}
