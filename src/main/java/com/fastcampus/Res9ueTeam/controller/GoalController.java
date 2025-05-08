package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.GoalRequestDto;
import com.fastcampus.Res9ueTeam.dto.GoalResponseDto;
import com.fastcampus.Res9ueTeam.entity.Goal;
import com.fastcampus.Res9ueTeam.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/goals")
@RestController
@AllArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<GoalResponseDto> saveGoal(@RequestBody GoalRequestDto dto) {
        GoalResponseDto response = goalService.savedGoal(dto);
        return ResponseEntity.ok(response);
    }
}
