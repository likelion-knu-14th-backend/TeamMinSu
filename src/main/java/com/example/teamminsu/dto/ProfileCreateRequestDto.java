package com.example.teamminsu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileCreateRequestDto {
    private String bio;
    private String phoneNum;
}