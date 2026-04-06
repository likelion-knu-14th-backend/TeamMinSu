package com.example.teamminsu;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assignment")

public class AssignmentController {
    private final List<AssignmentResponseDto> assignmentStore = new ArrayList<>();

    // POST
    @PostMapping
    public AssignmentResponseDto createAssignment(@RequestBody AssignmentRequestDto request) {
        AssignmentResponseDto assignment1 = new AssignmentResponseDto(
                request.getTeamName(),
                request.getAssignmentNumber(),
                request.getAge(),
                request.getSession()
        );
        assignmentStore.add(assignment1);
        return assignment1;
    }

    //GET
    @GetMapping
    public List<AssignmentResponseDto> getAssignments() {
        return assignmentStore;
    }

    //GET  단건
    @GetMapping("/{teamName}")
    public AssignmentResponseDto getAssignment(@PathVariable String teamName) {
        for (AssignmentResponseDto assignment : assignmentStore) {
            if (assignment.getTeamName().equals(teamName)) {
                return assignment;
            }
        }
        return null;
    }

    //PUT
    @PutMapping("/{assignmentNumber}")
    public AssignmentResponseDto updateAssignment(
            @PathVariable String assignmentNumber,
            @RequestBody AssignmentRequestDto request
    ) {
        for (int i = 0; i < assignmentStore.size(); i++) {
            AssignmentResponseDto assignment = assignmentStore.get(i);

            if (assignment.getAssignmentNumber().equals(assignmentNumber)) {
                // 새로운 데이터로 업데이트된 객체 생성
                AssignmentResponseDto updated = new AssignmentResponseDto(
                        request.getTeamName(),
                        request.getAssignmentNumber(),
                        request.getAge(),
                        request.getSession()
                );
                assignmentStore.set(i, updated); // 리스트의 해당 위치를 새 데이터로 교체
                return updated;
            }
        }
        return null;
    }

    //DELETE
    @DeleteMapping("/{assignmentNumber}")
    public void deleteAssignment(@PathVariable String assignmentNumber) {
        for (int i = 0; i < assignmentStore.size(); i++) {
            AssignmentResponseDto assignment = assignmentStore.get(i);
            if (assignment.getAssignmentNumber().equals(assignmentNumber)) {
                assignmentStore.remove(i);
            }
        }
    }
}
