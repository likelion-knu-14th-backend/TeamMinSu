package com.example.teamminsu.entity;

import com.example.teamminsu.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String studentNumber;

    private Integer age;

    // 추가
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


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