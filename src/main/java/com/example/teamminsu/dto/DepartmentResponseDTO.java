package com.example.teamminsu.dto;

import com.example.teamminsu.entity.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepartmentResponseDTO {
    private String departmentName;

    public DepartmentResponseDTO(Department department){
        this.departmentName = department.getDepartmentName();
    }
}
