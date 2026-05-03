package com.example.teamminsu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String studentNumber;

    private Integer age;

//    private String major;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Student(String name, String studentNumber, Integer age) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.age = age;
//        this.major = major;
    }

    public void update(String name, String studentNumber, Integer age) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.age = age;
//        this.major = major;
    }

    public void setDepartment(Department department){
        this.department = department;
    }
}