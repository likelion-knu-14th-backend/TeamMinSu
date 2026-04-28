package com.example.teamminsu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookRequestDto {

    private String title;
    private String author;
    private Integer price;
}