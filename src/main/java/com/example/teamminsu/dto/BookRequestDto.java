package com.example.teamminsu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "저자는 필수입니다.")
    private String author;

    @NotNull(message = "가격은 필수입니다.")
    @Positive(message = "가격은 양수여야 합니다.")
    private Integer price;
}