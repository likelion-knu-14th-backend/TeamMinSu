package com.example.Controller;

import com.example.dto.HobbyRequestDto;
import com.example.service.HobbyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hobbies")
@RequiredArgsConstructor
public class HobbyController {
    private final HobbyService hobbyService;

    @PostMapping("/{studentNumber}")
    public void addHobby(
            @PathVariable("studentNumber") String studentNumber,
            @Valid @RequestBody HobbyRequestDto dto) {
        hobbyService.addHobby(studentNumber, dto);
    }

    @DeleteMapping("/{hobbyId}")
    public void deleteHobby(@PathVariable("hobbyId") Long hobbyId) {
        hobbyService.deleteHobby(hobbyId);
    }
}