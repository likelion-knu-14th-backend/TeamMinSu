package com.example.teamminsu.sojin;

import com.example.teamminsu.StudentCreateRequestDto;
import com.example.teamminsu.StudentResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final List<TodoResponseDTO> todoStore = new ArrayList<>();

    // POST - todo 등록


    // GET - 전체 조회


    // GET - 단건 조회


    // PUT - id 기준 수정


    // DELETE - id 기준 삭제

}
