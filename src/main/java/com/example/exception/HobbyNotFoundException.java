package com.example.exception;

public class HobbyNotFoundException extends RuntimeException {

    public HobbyNotFoundException() {
        super("해당 취미가 존재하지 않습니다.");
    }
}