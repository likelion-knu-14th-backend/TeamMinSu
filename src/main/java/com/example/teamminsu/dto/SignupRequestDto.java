package com.example.teamminsu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank // null + 빈 문자열 + 공백 문자열 전부 막음
    private String studentNumber;

    @NotNull // 빈 문자열이나 공백 문자열은 허용
    private Integer age;

    @NotBlank
    private String major;
}
