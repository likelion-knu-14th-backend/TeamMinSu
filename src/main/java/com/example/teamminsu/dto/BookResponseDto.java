package com.example.teamminsu.dto;

import com.example.teamminsu.entity.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {

    private Long id;
    private String title;
    private String author;
    private Integer price;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
    }
}