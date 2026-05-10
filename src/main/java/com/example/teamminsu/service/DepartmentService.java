package com.example.teamminsu.service;

import com.example.teamminsu.dto.DepartmentRequestDTO;
import com.example.teamminsu.dto.DepartmentResponseDTO;
import com.example.teamminsu.dto.StudentResponseDto;
import com.example.teamminsu.entity.Department;
import com.example.teamminsu.entity.Student;
import com.example.teamminsu.exception.DepartmentNotFoundException;
import com.example.teamminsu.repository.DepartmentRepository;
import com.example.teamminsu.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    //학과별 학생리스트
    public List<StudentResponseDto> getStudentByDepartment(Long departmentId){

        if (!departmentRepository.existsById(departmentId)) {
            throw new DepartmentNotFoundException();
        }

        List<Student> students = studentRepository.findByDepartmentId(departmentId);

        return students.stream().map(StudentResponseDto::new).toList();
    }

    //학과 생성
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request){
        Department department = new Department(request.getDepartmentName());
        Department saved = departmentRepository.save(department);
        return new DepartmentResponseDTO(saved);
    }
}
