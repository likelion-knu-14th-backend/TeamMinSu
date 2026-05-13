package com.example.service;

import com.example.dto.HobbyRequestDto;
import com.example.entity.Hobby;
import com.example.entity.Student;
import com.example.exception.HobbyNotFoundException;
import com.example.exception.StudentNotFoundException;        // ← 추가!
import com.example.repository.HobbyRepository;
import com.example.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class HobbyService {
    private final StudentRepository studentRepository;
    private final HobbyRepository hobbyRepository;

    @Transactional
    public void addHobby(String studentNumber, HobbyRequestDto dto) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(StudentNotFoundException::new);     // ← 학생을 못 찾은 것!

        Hobby hobby = new Hobby();
        hobby.setHobbyName(dto.getHobbyName());
        hobby.setStudent(student);

        hobbyRepository.save(hobby);
    }

    @Transactional
    public void deleteHobby(Long hobbyId) {
        Hobby hobby = hobbyRepository.findById(hobbyId)
                .orElseThrow(HobbyNotFoundException::new);       // ← 취미를 못 찾은 것!
        hobbyRepository.delete(hobby);
    }
}