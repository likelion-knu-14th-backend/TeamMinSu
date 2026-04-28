package com.example.teamminsu.repository;

import com.example.teamminsu.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}