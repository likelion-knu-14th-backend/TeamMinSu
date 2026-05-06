package com.example.teamminsu.repository;

import com.example.teamminsu.entity.Profile;
import com.example.teamminsu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByStudent(Student student);
}