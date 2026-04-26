package com.example.teamminsu.sukhoon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        //종목명

    @Column(nullable = false)
    private Integer repsPerSet;         //세트당 개수

    private Integer sets;       //세트 수

    private String duration;        //걸린 시간

    public Health(String name, Integer repsPerSet, Integer sets, String duration) {
        this.name = name;
        this.repsPerSet = repsPerSet;
        this.sets = sets;
        this.duration = duration;
    }

    public void update(String name, Integer repsPerSet, Integer sets, String duration) {
        this.name = name;
        this.repsPerSet = repsPerSet;
        this.sets = sets;
        this.duration = duration;
    }
}