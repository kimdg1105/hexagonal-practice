package com.msa.book.application.inputport;

import com.msa.book.application.mapper.BookMapper;
import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.InQueryUseCase;
import com.msa.book.domain.Book;
import com.msa.book.framework.web.dto.BookOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InQueryInputPort implements InQueryUseCase {
    private final BookOutputPort bookOutputPort;

    private final BookMapper bookMapper;

    @Override
    public BookOutputDto getBookInfo(Long bookNo) {
        Book book = bookOutputPort.getBookById(bookNo);
        return bookMapper.toBookOutputDto(book);
    }
}
