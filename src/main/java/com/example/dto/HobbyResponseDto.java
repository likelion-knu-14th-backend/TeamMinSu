package com.example.dto;

import com.example.entity.Hobby;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class HobbyResponseDto {
    private String hobbyName;

    public HobbyResponseDto(Hobby hobby) {
        this.hobbyName = hobby.getHobbyName();


    }
}
