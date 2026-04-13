package com.example.teamminsu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;
    private Integer priority;

    public Todo(String title, Boolean completed, Integer priority){
        this.title = title;
        this.completed = completed;
        this.priority = priority;
    }

    public void update(String title, Boolean completed, Integer priority){
        this.title = title;
        this.completed = completed;
        this.priority = priority;
    }
}
