package com.example.teamminsu.dto;

import com.example.teamminsu.entity.Profile;
import lombok.Getter;

@Getter
public class ProfileResponseDto {
    private String bio;
    private String phoneNum;

    public ProfileResponseDto(Profile profile) {
        this.bio = profile.getBio();
        this.phoneNum = profile.getPhoneNum();
    }
}
