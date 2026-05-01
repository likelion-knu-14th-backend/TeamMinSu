package com.example.teamminsu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GradeCreateRequestDto {
    private String subjectName;
    private String grade;
}