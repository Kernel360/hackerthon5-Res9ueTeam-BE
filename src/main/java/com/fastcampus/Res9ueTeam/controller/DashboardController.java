package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.DashboardRequestDto;
import com.fastcampus.Res9ueTeam.dto.DashboardResponseDto;
import com.fastcampus.Res9ueTeam.service.DashboardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/dashboard")
@AllArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @PostMapping("/category-expense")
    public ResponseEntity<List<DashboardResponseDto>> getCategoryStats(@RequestBody DashboardRequestDto requestDto) {
        log.info("요청된 사용자 ID: {}", requestDto.getId());
        List<DashboardResponseDto> stats = dashboardService.getCategoryStats(requestDto);
        return ResponseEntity.ok(stats);
    }
}
