package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.BookInfoDto;
import com.msa.book.framework.web.dto.BookOutputDto;

public interface AddBookUseCase {
    BookOutputDto addBook(BookInfoDto bookInfoDto);
}
