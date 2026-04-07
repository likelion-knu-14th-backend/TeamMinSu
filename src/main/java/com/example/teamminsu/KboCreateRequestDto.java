package com.example.teamminsu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KboCreateRequestDto {

    private String day;
    private String time;
    private String myTeam; // 우리팀
    private String opTeam; // 상대팀
}
