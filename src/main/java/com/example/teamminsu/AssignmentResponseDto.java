package com.example.teamminsu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
public class AssignmentResponseDto {
    private String teamName;
    private String assignmentNumber;
    private Integer age;
    private String session;
}
