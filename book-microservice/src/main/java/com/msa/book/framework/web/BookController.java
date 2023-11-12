package com.msa.book.framework.web;

import com.msa.book.application.usecase.AddBookUseCase;
import com.msa.book.application.usecase.InQueryUseCase;
import com.msa.book.application.usecase.MakeAvailableUseCase;
import com.msa.book.application.usecase.MakeUnAvailableUseCase;
import com.msa.book.framework.web.dto.BookInfoDto;
import com.msa.book.framework.web.dto.BookOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final InQueryUseCase inQueryUseCase;
    private final AddBookUseCase addBookUseCase;
    private final MakeAvailableUseCase makeAvailableUseCase;
    private final MakeUnAvailableUseCase makeUnAvailableUseCase;

    @GetMapping("/{bookNo}")
    public ResponseEntity<BookOutputDto> getBookInfo(@PathVariable Long bookNo) {
        return ResponseEntity.ok(inQueryUseCase.getBookInfo(bookNo));
    }

    @PostMapping
    public ResponseEntity<BookOutputDto> addBook(@RequestBody BookInfoDto bookInfoDto) {
        return ResponseEntity.ok(addBookUseCase.addBook(bookInfoDto));
    }

    @PutMapping("/{bookNo}/available")
    public ResponseEntity<BookOutputDto> makeAvailable(@PathVariable Long bookNo) {
        return ResponseEntity.ok(makeAvailableUseCase.makeAvailable(bookNo));
    }

    @PutMapping("/{bookNo}/unavailable")
    public ResponseEntity<BookOutputDto> makeUnAvailable(@PathVariable Long bookNo) {
        return ResponseEntity.ok(makeUnAvailableUseCase.makeUnAvailable(bookNo));
    }

}
