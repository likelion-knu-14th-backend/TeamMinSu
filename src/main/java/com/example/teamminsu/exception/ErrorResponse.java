package com.example.teamminsu.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
