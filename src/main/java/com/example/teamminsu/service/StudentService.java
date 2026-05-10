package com.example.teamminsu.service;


import com.example.teamminsu.dto.StudentCreateRequestDto;
import com.example.teamminsu.dto.StudentResponseDto;
import com.example.teamminsu.entity.Department;
import com.example.teamminsu.entity.Student;
import com.example.teamminsu.exception.DepartmentNotFoundException;
import com.example.teamminsu.exception.StudentNotFoundException;
import com.example.teamminsu.repository.DepartmentRepository;
import com.example.teamminsu.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public StudentResponseDto createStudent(StudentCreateRequestDto request) {
        Student student = new Student(
                request.getName(),
                request.getStudentNumber(),
                request.getAge()
        );

        Department department = new Department();
        department.setId(request.getDepartmentId());
        student.setDepartment(department);

        Student savedStudent = studentRepository.save(student);
        return new StudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDto::new)
                .toList();
    }

    public StudentResponseDto getStudent(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(StudentNotFoundException::new);

        return new StudentResponseDto(student);
    }

    @Transactional
    public StudentResponseDto updateStudent(String studentNumber, StudentCreateRequestDto request) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(StudentNotFoundException::new);

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(DepartmentNotFoundException::new);

        student.update(
                request.getName(),
                request.getStudentNumber(),
                request.getAge()
        );

        student.setDepartment(department);

        Student updatedStudent = studentRepository.save(student);
        return new StudentResponseDto(updatedStudent);
    }

    public void deleteStudent(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(StudentNotFoundException::new);

        studentRepository.delete(student);
    }

    @Transactional
    public void deleteDepartment(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(StudentNotFoundException::new);

        student.setDepartment(null);
    }
}
