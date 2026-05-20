package com.example.teamminsu.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("해당 도서가 존재하지 않습니다.");
    }
}