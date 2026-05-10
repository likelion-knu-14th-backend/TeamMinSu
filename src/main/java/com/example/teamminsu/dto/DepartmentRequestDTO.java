package com.example.teamminsu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepartmentRequestDTO {
    @NotBlank(message = "학과명은 필수입니다.")
    private String departmentName;
}
