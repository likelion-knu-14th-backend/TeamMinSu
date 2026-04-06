package com.example.teamminsu.sojin;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequestDTO {
    private String id;
    private String title;
    private Boolean completed;
    private Integer priority;
}
