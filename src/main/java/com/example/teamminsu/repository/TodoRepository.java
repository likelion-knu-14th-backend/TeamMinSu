package com.example.teamminsu.repository;

import com.example.teamminsu.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, String> {
    Optional<Todo> findByTitle(String title);
}
