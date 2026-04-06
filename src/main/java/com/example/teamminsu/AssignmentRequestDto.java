package com.example.teamminsu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssignmentRequestDto {
    private String teamName;
    private String assignmentNumber;
    private Integer age;
    private String session;
}