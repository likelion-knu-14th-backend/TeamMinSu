package com.example.teamminsu.sukhoon.controller;

import com.example.teamminsu.sukhoon.dto.HealthCreateRequestDto;
import com.example.teamminsu.sukhoon.dto.HealthResponseDto;
import com.example.teamminsu.sukhoon.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sukhoon/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    // 운동 등록
    @PostMapping
    public HealthResponseDto create(@RequestBody HealthCreateRequestDto request) {
        return healthService.createHealth(request);
    }

    // 전체 조회
    @GetMapping
    public List<HealthResponseDto> getAll() {
        return healthService.getHealths();
    }

    // 운동 명 기준 단건 조회
    @GetMapping("/{name}")
    public HealthResponseDto getOne(@PathVariable String name) {
        return healthService.getHealth(name);
    }

    // 운동 명 기준 수정
    @PutMapping("/{name}")
    public HealthResponseDto updateHealth(
            @PathVariable String name,
            @RequestBody HealthCreateRequestDto request
    ) {
        return healthService.updateHealth(name, request);
    }

    // 운동 명 기준 삭제
    @DeleteMapping("/{name}")
    public void deleteHealth(@PathVariable String name) {
        healthService.deleteHealth(name);
    }
}