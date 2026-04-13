package com.example.teamminsu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequestDTO {
    private String title;
    private Boolean completed;
    private Integer priority;
}
