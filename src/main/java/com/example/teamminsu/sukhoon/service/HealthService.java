package com.example.teamminsu.sukhoon.service;


import com.example.teamminsu.sukhoon.dto.HealthCreateRequestDto;
import com.example.teamminsu.sukhoon.dto.HealthResponseDto;
import com.example.teamminsu.sukhoon.entity.Health;
import com.example.teamminsu.sukhoon.repository.HealthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final HealthRepository healthRepository;

    public HealthResponseDto createHealth(HealthCreateRequestDto request) {
        Health health = new Health(
                request.getName(),
                request.getRepsPerSet(),
                request.getSets(),
                request.getDuration()
        );

        Health savedHealth = healthRepository.save(health);
        return new HealthResponseDto(savedHealth);
    }

    public List<HealthResponseDto> getHealths() {
        return healthRepository.findAll()
                .stream()
                .map(HealthResponseDto::new)
                .toList();
    }

    public HealthResponseDto getHealth(String name) {
        Health health = healthRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 운동 기록이 존재하지 않습니다."));

        return new HealthResponseDto(health);
    }

    public HealthResponseDto updateHealth(String name, HealthCreateRequestDto request) {
        Health health = healthRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 운동 기록이 존재하지 않습니다."));

        health.update(
                request.getName(),
                request.getRepsPerSet(),
                request.getSets(),
                request.getDuration()
        );

        Health updatedHealth = healthRepository.save(health);
        return new HealthResponseDto(health);
    }

    public void deleteHealth(String name) {
        Health health = healthRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 운동 기록이 존재하지 않습니다."));

        healthRepository.delete(health);
    }
}