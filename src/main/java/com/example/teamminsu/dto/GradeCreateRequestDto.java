package com.example.teamminsu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GradeCreateRequestDto {

    @NotBlank(message = "과목명은 필수입니다.")
    private String subjectName;

    @NotBlank(message = "성적은 필수입니다.")
    private String grade;
}