package com.example.teamminsu.service;

import com.example.teamminsu.dto.ProfileCreateRequestDto;
import com.example.teamminsu.dto.ProfileResponseDto;
import com.example.teamminsu.entity.Profile;
import com.example.teamminsu.entity.Student;
import com.example.teamminsu.repository.ProfileRepository;
import com.example.teamminsu.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {

    private final StudentRepository studentRepository;
    private final ProfileRepository profileRepository;

    public ProfileResponseDto addProfile(String studentNumber, ProfileCreateRequestDto dto) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));

        Profile profile = new Profile(dto.getBio(), dto.getPhoneNum(), student);
        profileRepository.save(profile);

        return new ProfileResponseDto(profile);
    }

    public void deleteProfile(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));

        Profile profile = profileRepository.findByStudent(student)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로필이 존재하지 않습니다."));

        profileRepository.delete(profile);
    }
}