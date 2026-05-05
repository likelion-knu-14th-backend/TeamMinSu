package com.example.Controller;

import com.example.dto.GradeRequestDto;
import com.example.dto.GradeResponseDto;
import com.example.service.GradeService;
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
            @PathVariable("studentNumber") String studentNumber,
            @RequestBody List<GradeRequestDto> gradeRequestDtoList
    ) {
        gradeService.uploadStudentGrade(studentNumber, gradeRequestDtoList);
    }

    @GetMapping("/{studentNumber}")
    public List<GradeResponseDto> getStudentGrade(
            @PathVariable("studentNumber") String studentNumber) {
        return gradeService.getStudentGrade(studentNumber);
    }
}