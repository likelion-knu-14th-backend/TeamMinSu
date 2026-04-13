package com.example.teamminsu.controller;

import com.example.teamminsu.dto.TodoCreateRequestDTO;
import com.example.teamminsu.dto.TodoResponseDTO;
import com.example.teamminsu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // POST - todo 등록
    @PostMapping
    public TodoResponseDTO createTodo(@RequestBody TodoCreateRequestDTO request) {
        return todoService.createTodo(request);
    }

    // GET - 전체 조회
    @GetMapping
    public List<TodoResponseDTO> getTodos() {
        return todoService.getTodos();
    }

    // GET - 단건 조회
    @GetMapping("/{todoTitle}")
    public TodoResponseDTO getTodo(@PathVariable String todoTitle) {
        return todoService.getTodo(todoTitle);
    }

    // PUT - title 기준 수정
    @PutMapping("/{todoTitle}")
    public TodoResponseDTO updateTodo(
            @PathVariable String todoTitle,
            @RequestBody TodoCreateRequestDTO request) {
        return todoService.updateTodo(todoTitle, request);
    }

    // DELETE - title 기준 삭제
    @DeleteMapping("/{todoTitle}")
    public void deleteTodo(@PathVariable String todoTitle) {
        todoService.deleteTodo(todoTitle);
    }

}
