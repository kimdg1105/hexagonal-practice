package com.msa.book.framework.web.dto;

import com.msa.book.domain.vo.BookStatus;

public record BookOutputDto(
        Long bookNo,
        String bookTitle,
        BookStatus bookStatus
) {
}
