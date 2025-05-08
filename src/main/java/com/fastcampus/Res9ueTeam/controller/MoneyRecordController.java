package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.MoneyRecordRequestDto;
import com.fastcampus.Res9ueTeam.dto.MoneyRecordResponseDto;
import com.fastcampus.Res9ueTeam.entity.Category;
import com.fastcampus.Res9ueTeam.entity.CategoryType;
import com.fastcampus.Res9ueTeam.entity.PaymentType;
import com.fastcampus.Res9ueTeam.service.MoneyRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class MoneyRecordController {

    private final MoneyRecordService moneyRecordService;

    @GetMapping
    public List<MoneyRecordResponseDto> getPayment(
            @RequestParam(required = false) Long user_id,           // 사용자 ID
            @RequestParam(required = false) int amount,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) CategoryType category_type,
            @RequestParam(required = false) PaymentType payment_type,
            @RequestParam(required = false) LocalDate record_date
    ) {
        MoneyRecordRequestDto moneyRecordRequestDto = new MoneyRecordRequestDto(
                user_id, amount, category, category_type, payment_type, record_date); //

        return moneyRecordService.getPayment(moneyRecordRequestDto);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPayment(@RequestBody @Valid MoneyRecordRequestDto dto) {
        moneyRecordService.savePayment(dto);
        return ResponseEntity.ok("데이터가 성공적으로 저장되었습니다.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        moneyRecordService.deletePayment(id);
        return ResponseEntity.ok("데이터가 성공적으로 삭제되었습니다.");
    }
}