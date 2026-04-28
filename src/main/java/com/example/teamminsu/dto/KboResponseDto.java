package com.example.teamminsu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KboResponseDto {

    private String day;
    private String time;
    private String myTeam; // 우리팀
    private String opTeam; // 상대팀
}
