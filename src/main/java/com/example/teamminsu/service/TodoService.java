package com.example.teamminsu.service;

import com.example.teamminsu.dto.TodoCreateRequestDTO;
import com.example.teamminsu.dto.TodoResponseDTO;
import com.example.teamminsu.entity.Todo;
import com.example.teamminsu.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponseDTO createTodo(TodoCreateRequestDTO request) {
        Todo todo = new Todo(
                request.getTitle(),
                request.getCompleted(),
                request.getPriority()
        );

        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDTO(savedTodo);
    }

    public List<TodoResponseDTO> getTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDTO::new)
                .toList();
    }

    public TodoResponseDTO getTodo(String title) {
        Todo todo = todoRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("해당 목록이 존재하지 않습니다."));

        return new TodoResponseDTO(todo);
    }

    public TodoResponseDTO updateTodo(String title, TodoCreateRequestDTO request) {
        Todo todo = todoRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("해당 목록이 존재하지 않습니다."));

        todo.update(
                request.getTitle(),
                request.getCompleted(),
                request.getPriority()
        );

        Todo updateTodo = todoRepository.save(todo);
        return new TodoResponseDTO(updateTodo);
    }

    public void deleteTodo(String title) {
        Todo todo = todoRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("해당 목록이 존재하지 않습니다."));
        todoRepository.delete(todo);
    }
}
