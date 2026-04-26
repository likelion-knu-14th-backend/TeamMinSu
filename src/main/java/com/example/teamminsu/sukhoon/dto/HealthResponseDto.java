package com.example.teamminsu.sukhoon.dto;

import com.example.teamminsu.sukhoon.entity.Health;
import lombok.Getter;

@Getter

public class HealthResponseDto {
    private String name;        //종목명

    private Integer repsPerSet;         //세트당 개수

    private Integer sets;       //세트 수

    private String duration;        //걸린 시간

    public HealthResponseDto(Health health) {
        this.name = health.getName();
        this.repsPerSet = health.getRepsPerSet();
        this.sets = health.getSets();
        this.duration = health.getDuration();
    }

}
