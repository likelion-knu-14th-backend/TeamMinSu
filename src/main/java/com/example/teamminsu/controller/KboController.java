package com.example.teamminsu.controller;

import com.example.teamminsu.dto.KboCreateRequestDto;
import com.example.teamminsu.dto.KboResponseDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/baseball")
public class KboController {

    private final List<KboResponseDto> kboStore = new ArrayList<>();

    // 1. POST - 야구 일정 등록
    @PostMapping
    public KboResponseDto createKbo(@RequestBody KboCreateRequestDto request) {
        KboResponseDto baseball = new KboResponseDto(
                request.getDay(),
                request.getTime(),
                request.getMyTeam(),
                request.getOpTeam()
        );

        kboStore.add(baseball);
        return baseball;
    }

    // 2. GET - 전체  조회
    @GetMapping
    public List<KboResponseDto> getKboList() {
        return kboStore;
    }

    // 3. GET - 특정 요일 일정 조회 (단건 조회)
    @GetMapping("/{day}")
    public KboResponseDto getKbo(@PathVariable String day) {
        for (KboResponseDto kbo : kboStore) {
            if (kbo.getDay().equals(day)) {
                return kbo;
            }
        }
        return null;
    }

    // 4. PUT - 요일 기준 수정
    @PutMapping("/{day}")
    public KboResponseDto updateKbo(
            @PathVariable String day,
            @RequestBody KboCreateRequestDto request
    ) {
        for (int i = 0; i < kboStore.size(); i++) {
            KboResponseDto kbo = kboStore.get(i);

            if (kbo.getDay().equals(day)) {
                // 실습 코드 방식대로 새로운 객체 생성 후 set
                KboResponseDto updatedKbo = new KboResponseDto(
                        request.getDay(),
                        request.getTime(),
                        request.getMyTeam(),
                        request.getOpTeam()
                );

                kboStore.set(i, updatedKbo);
                return updatedKbo;
            }
        }
        return null;
    }

    // 5. DELETE - 요일 기준 삭제
    @DeleteMapping("/{day}")
    public void deleteKbo(@PathVariable String day) {
        for (int i = 0; i < kboStore.size(); i++) {
            KboResponseDto kbo = kboStore.get(i);

            if (kbo.getDay().equals(day)) {
                kboStore.remove(i);
                return;
            }
        }
    }
}