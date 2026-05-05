package com.example.service;

import com.example.dto.HobbyRequestDto;
import com.example.entity.Hobby;
import com.example.entity.Student;
import com.example.repository.HobbyRepository;
import com.example.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HobbyService {
    private final StudentRepository studentRepository;
    private final HobbyRepository hobbyRepository;

    public void addHobby(String studentNumber, HobbyRequestDto dto) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));

        Hobby hobby = new Hobby();
        hobby.setHobbyName(dto.getHobbyName());
        hobby.setStudent(student);              // ← 관계 설정

        hobbyRepository.save(hobby);
    }

    public void deleteHobby(Long hobbyId) {
        hobbyRepository.deleteById(hobbyId);
    }
}