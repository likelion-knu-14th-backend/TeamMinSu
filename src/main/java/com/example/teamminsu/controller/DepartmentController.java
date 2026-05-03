package com.example.teamminsu.controller;

import com.example.teamminsu.dto.DepartmentRequestDTO;
import com.example.teamminsu.dto.DepartmentResponseDTO;
import com.example.teamminsu.dto.StudentResponseDto;
import com.example.teamminsu.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public List<StudentResponseDto> getStudentDepartment(@PathVariable("departmentId") Long departmentId){
        return departmentService.getStudentByDepartment(departmentId);
    }

    @PostMapping
    public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO request){
        return departmentService.createDepartment(request);
    }

}
