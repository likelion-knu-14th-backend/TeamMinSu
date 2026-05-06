package com.example.teamminsu.dto;

import com.example.teamminsu.entity.Grade;
import lombok.Getter;

@Getter
public class GradeResponseDto {
    private String subjectName;
    private String grade;

    public GradeResponseDto(Grade grade) {
        this.subjectName = grade.getSubjectName();
        this.grade = grade.getGrade();
    }
}