package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.DashboardRequestDto;
import com.fastcampus.Res9ueTeam.dto.DashboardResponseDto;
import com.fastcampus.Res9ueTeam.service.DashboardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/dashboard")
@AllArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/category-expense")
    public ResponseEntity<List<DashboardResponseDto>> getCategoryStats(@RequestParam Long id) {
        log.info("요청된 사용자 ID: {}", id);

        // DashboardRequestDto 생성 (서비스 로직 변경 없이 그대로 사용하기 위함)
        DashboardRequestDto requestDto = new DashboardRequestDto(id);

        List<DashboardResponseDto> stats = dashboardService.getCategoryStats(requestDto);
        return ResponseEntity.ok().body(stats);
    }
}
