package com.example.teamminsu.controller;


import com.example.teamminsu.dto.StudentCreateRequestDto;
import com.example.teamminsu.dto.StudentResponseDto;
import com.example.teamminsu.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // POST - 학생 등록
    @PostMapping
    public StudentResponseDto createStudent(@RequestBody StudentCreateRequestDto request) {
        return studentService.createStudent(request);
    }

    // GET - 전체 조회
    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return studentService.getStudents();
    }

    // GET - 단건 조회
    @GetMapping("/{studentNumber}")
    public StudentResponseDto getStudent(@PathVariable String studentNumber) {
        return studentService.getStudent(studentNumber);
    }

    // PUT - 학번 기준 수정
    @PutMapping("/{studentNumber}")
    public StudentResponseDto updateStudent(
            @PathVariable String studentNumber,
            @RequestBody StudentCreateRequestDto request) {
        return studentService.updateStudent(studentNumber, request);
    }

    // DELETE - 학번 기준 삭제
    @DeleteMapping("/{studentNumber}")
    public void deleteStudent(@PathVariable String studentNumber) {
        studentService.deleteStudent(studentNumber);
    }

    // DELETE - 학번 기준 학과 삭제
    @DeleteMapping("/{studentNumber}/department")
    public void deleteDepartment(@PathVariable String studentNumber) {
        studentService.deleteDepartment(studentNumber);
    }
}
