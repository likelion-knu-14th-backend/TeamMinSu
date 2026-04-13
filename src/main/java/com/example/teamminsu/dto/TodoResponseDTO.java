package com.example.teamminsu.dto;

import com.example.teamminsu.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class TodoResponseDTO {
    private String title;
    private Boolean completed;
    private Integer priority;

    public TodoResponseDTO(Todo todo){
        this.title = todo.getTitle();
        this.completed = todo.getCompleted();
        this.priority = todo.getPriority();
    }
}
