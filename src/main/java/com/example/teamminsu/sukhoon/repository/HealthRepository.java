package com.example.teamminsu.sukhoon.repository;

import com.example.teamminsu.sukhoon.entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthRepository extends JpaRepository<Health, Long> {
    Optional<Health> findByName(String name);
}

