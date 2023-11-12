package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.BookOutputDto;

public interface InQueryUseCase {
    public BookOutputDto getBookInfo(Long bookNo);
}
