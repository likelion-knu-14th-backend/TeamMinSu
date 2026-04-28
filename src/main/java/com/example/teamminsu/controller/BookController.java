package com.example.teamminsu.controller;

import com.example.teamminsu.dto.BookRequestDto;
import com.example.teamminsu.dto.BookResponseDto;
import com.example.teamminsu.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 도서 등록
    @PostMapping
    public BookResponseDto createBook(@RequestBody BookRequestDto request) {
        return bookService.createBook(request);
    }

    // 전체 도서 조회
    @GetMapping
    public List<BookResponseDto> getBooks() {
        return bookService.getBooks();
    }

    // 단건 도서 조회
    @GetMapping("/{id}")
    public BookResponseDto getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    // 도서 수정
    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id, @RequestBody BookRequestDto request) {
        return bookService.updateBook(id, request);
    }

    // 도서 삭제
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}