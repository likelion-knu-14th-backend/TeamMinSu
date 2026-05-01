package com.example.teamminsu.repository;

import com.example.teamminsu.entity.Grade;
import com.example.teamminsu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudent(Student student);
}