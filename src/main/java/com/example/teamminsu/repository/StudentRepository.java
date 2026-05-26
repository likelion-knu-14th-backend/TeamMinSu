package com.example.teamminsu.repository;



import com.example.teamminsu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNumber(String studentNumber);
    List<Student> findByDepartmentId(Long departmentId);
    // 회원가입 시 이메일 중복 여부 확인
    boolean existsByEmail(String email);

    // 로그인 시 이메일로 학생 조회
    Optional<Student> findByEmail(String email);
}
