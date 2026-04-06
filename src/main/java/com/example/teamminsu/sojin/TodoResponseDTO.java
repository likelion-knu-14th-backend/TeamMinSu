package com.example.teamminsu.sojin;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDTO {
    private String id;
    private String title;
    private Boolean completed;
    private Integer priority;
}
