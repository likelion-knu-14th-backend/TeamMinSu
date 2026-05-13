package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class HobbyRequestDto {

    @NotBlank(message = "취미 종류는 필수입니다.")
    private String hobbyName;


}
