package com.example.repository;

import com.example.entity.Hobby;
import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long>{
    List<Hobby> findByStudent(Student student);

}
