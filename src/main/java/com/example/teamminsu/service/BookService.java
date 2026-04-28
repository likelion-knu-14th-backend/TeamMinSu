package com.example.teamminsu.service;

import com.example.teamminsu.dto.BookRequestDto;
import com.example.teamminsu.dto.BookResponseDto;
import com.example.teamminsu.entity.Book;
import com.example.teamminsu.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDto createBook(BookRequestDto request) {
        Book book = new Book(request.getTitle(), request.getAuthor(), request.getPrice());
        return new BookResponseDto(bookRepository.save(book));
    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDto::new)
                .toList();
    }

    public BookResponseDto getBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 도서가 존재하지 않습니다."));
        return new BookResponseDto(book);
    }

    public BookResponseDto updateBook(Long id, BookRequestDto request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 도서가 존재하지 않습니다."));
        book.update(request.getTitle(), request.getAuthor(), request.getPrice());
        return new BookResponseDto(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 도서가 존재하지 않습니다."));
        bookRepository.delete(book);
    }
}