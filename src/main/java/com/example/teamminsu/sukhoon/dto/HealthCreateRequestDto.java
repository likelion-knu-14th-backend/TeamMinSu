package com.example.teamminsu.sukhoon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class HealthCreateRequestDto {
    private String name;        //종목명

    private Integer repsPerSet;         //세트당 개수

    private Integer sets;       //세트 수

    private String duration;        //걸린 시간

}
