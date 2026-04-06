package com.example.teamminsu.sojin;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final List<TodoResponseDTO> todoStore = new ArrayList<>();

    // POST - todo 등록
    @PostMapping
    public TodoResponseDTO createTodo(@RequestBody TodoRequestDTO request) {
        TodoResponseDTO todo = new TodoResponseDTO(
                request.getId(),
                request.getTitle(),
                request.getCompleted(),
                request.getPriority()
        );

        todoStore.add(todo);
        return todo;
    }

    // GET - 전체 조회
    @GetMapping
    public List<TodoResponseDTO> getTodos() {
        return todoStore;
    }

    // GET - 단건 조회
    @GetMapping("/{todoId}")
    public TodoResponseDTO getTodo(@PathVariable String todoId) {
        for(TodoResponseDTO todo : todoStore) {
            if(todo.getId().equals(todoId)) {
                return todo;
            }
        }
        return null;
    }

    // PUT - id 기준 수정
    @PutMapping("/{todoId}")
    public TodoResponseDTO updateTodo(
            @PathVariable String todoId,
            @RequestBody TodoRequestDTO request) {
        for (int i = 0; i < todoStore.size(); i++) {
            TodoResponseDTO todo = todoStore.get(i);

            if (todo.getId().equals(todoId)) {
                TodoResponseDTO updatedTodo = new TodoResponseDTO(
                        request.getId(),
                        request.getTitle(),
                        request.getCompleted(),
                        request.getPriority()
                );
                todoStore.set(i, updatedTodo);
                return updatedTodo;
            }
        }
        return null;
    }

    // DELETE - id 기준 삭제
    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable String todoId) {
        for (int i = 0; i < todoStore.size(); i++) {
            TodoResponseDTO todo = todoStore.get(i);

            if (todo.getId().equals(todoId)) {
                todoStore.remove(i);
            }
        }
    }

}
