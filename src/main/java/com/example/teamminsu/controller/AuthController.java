package com.example.teamminsu.controller;


import com.example.teamminsu.dto.LoginRequestDto;
import com.example.teamminsu.dto.SignupRequestDto;
import com.example.teamminsu.dto.TokenResponseDto;
import com.example.teamminsu.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequestDto request){
        authService.signup(request);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public TokenResponseDto login(@Valid @RequestBody LoginRequestDto request) {
        return authService.login(request);
    }
}
