package com.example.teamminsu.controller;

import com.example.teamminsu.dto.ProfileCreateRequestDto;
import com.example.teamminsu.dto.ProfileResponseDto;
import com.example.teamminsu.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/{studentNumber}")
    public ProfileResponseDto addProfile(
            @PathVariable String studentNumber,
            @RequestBody ProfileCreateRequestDto dto
    ) {
        return profileService.addProfile(studentNumber, dto);
    }

    @DeleteMapping("/{studentNumber}")
    public void deleteProfile(@PathVariable String studentNumber) {
        profileService.deleteProfile(studentNumber);
    }
}