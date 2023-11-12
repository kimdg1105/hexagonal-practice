package com.msa.book.application.mapper;

import com.msa.book.domain.Book;
import com.msa.book.framework.web.dto.BookOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(source = "book.no", target = "bookNo")
    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "book.status", target = "bookStatus")
    BookOutputDto toBookOutputDto(Book book);
}
