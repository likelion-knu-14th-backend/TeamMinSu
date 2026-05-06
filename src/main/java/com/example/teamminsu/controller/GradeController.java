package com.example.teamminsu.controller;

import com.example.teamminsu.dto.GradeCreateRequestDto;
import com.example.teamminsu.dto.GradeResponseDto;
import com.example.teamminsu.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping("/{studentNumber}")
    public void uploadStudentGrade(
            @PathVariable String studentNumber,
            @RequestBody List<GradeCreateRequestDto> gradeRequestDtoList
    ) {
        gradeService.uploadStudentGrade(studentNumber, gradeRequestDtoList);
    }

    @GetMapping("/{studentNumber}")
    public List<GradeResponseDto> getStudentGrade(@PathVariable String studentNumber) {
        return gradeService.getStudentGrade(studentNumber);
    }
}