package com.fastcampus.Res9ueTeam.service;

import com.fastcampus.Res9ueTeam.dto.DashboardRequestDto;
import com.fastcampus.Res9ueTeam.dto.DashboardResponseDto;
import com.fastcampus.Res9ueTeam.entity.Category;
import com.fastcampus.Res9ueTeam.entity.MoneyRecord;
import com.fastcampus.Res9ueTeam.repository.MoneyRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DashboardService {

    private final MoneyRecordRepository moneyRecordRepository;

    // DashboardRequestDto 에서 사용자 ID 받아 해당 사용자의 카테고리별로 그룹필 해서 전체 금액 대비 비율로환산
    public List<DashboardResponseDto> getCategoryStats(DashboardRequestDto requestDto) {
        Long userId = requestDto.getId();

        // 1. 사용자 기록 전체 조회 (지출 + 수입 모두 포함)
        List<MoneyRecord> records = moneyRecordRepository.findByUserId(userId);

        // 2. 카테고리별 금액 합산 (수입/지출 포함) . ! Java Stream API와 Collectors 유틸리티
        Map<Category, Long> grouped = records.stream()
                .collect(Collectors.groupingBy(
                        MoneyRecord::getCategory, // 카테고리별로 그룹핑
                        Collectors.summingLong(MoneyRecord::getAmount) // 금액을 합산
                ));

        // 3. 전체 금액 계산 -> 비율로 환산하기 위해
        long totalAmount = grouped.values().stream().mapToLong(Long::longValue).sum();

        List<DashboardResponseDto> result = new ArrayList<>();
        double accumulated = 0.0; // 마지막 카테고리에서 비율 누적 오차 보정용
        // Map의 Entry 집합을 리스트로 변환하여 순차적으로 처리
        List<Map.Entry<Category, Long>> entries = new ArrayList<>(grouped.entrySet());

        // 각 카테고리에 대해 DashboardResponseDto 생성
        for (int i = 0; i < entries.size(); i++) {
            Category category = entries.get(i).getKey();
            long amount = entries.get(i).getValue();

            // 전체 금액 대비 비율 계산 (소수점 계산 포함)
            double rawPercent = totalAmount == 0 ? 0 : (amount * 100.0 / totalAmount);

            // 마지막 항목은 누적 비율 오차를 보정 (총합이 정확히 100% 되도록)
            double rounded = (i == entries.size() - 1)
                    ? Math.round((100.0 - accumulated) * 10.0) / 10.0
                    : Math.round(rawPercent * 10.0) / 10.0;

            // 마지막 항목이 아니면 누적 비율에 추가
            if (i != entries.size() - 1) {
                accumulated += rounded;
            }

            result.add(new DashboardResponseDto(category.name(), amount, rounded));
        }

        return result;
    }

}
