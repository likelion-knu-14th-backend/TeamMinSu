package com.example.teamminsu.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException() {
        super("해당 학과가 존재하지 않습니다.");
    }
}
