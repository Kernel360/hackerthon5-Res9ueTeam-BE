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

    // DashboardRequestDto를 직접 받아 사용자 ID로 통계 계산
    public List<DashboardResponseDto> getCategoryStats(DashboardRequestDto requestDto) {
        Long userId = requestDto.getId();

        // 1. 사용자 기록 전체 조회 (지출 + 수입 모두 포함)
        List<MoneyRecord> records = moneyRecordRepository.findByUserId(userId);

        // 2. 카테고리별 금액 합산 (수입/지출 포함)
        Map<Category, Long> grouped = records.stream()
                .collect(Collectors.groupingBy(
                        MoneyRecord::getCategory,
                        Collectors.summingLong(MoneyRecord::getAmount)
                ));

        // 3. 전체 금액 계산
        long totalAmount = grouped.values().stream().mapToLong(Long::longValue).sum();

        List<DashboardResponseDto> result = new ArrayList<>();
        double accumulated = 0.0;
        List<Map.Entry<Category, Long>> entries = new ArrayList<>(grouped.entrySet());

        for (int i = 0; i < entries.size(); i++) {
            Category category = entries.get(i).getKey();
            long amount = entries.get(i).getValue();

            // 전체 금액 대비 퍼센트 계산
            double rawPercent = totalAmount == 0 ? 0 : (amount * 100.0 / totalAmount);
            double rounded = (i == entries.size() - 1)
                    ? Math.round((100.0 - accumulated) * 10.0) / 10.0
                    : Math.round(rawPercent * 10.0) / 10.0;

            if (i != entries.size() - 1) {
                accumulated += rounded;
            }

            result.add(new DashboardResponseDto(category.name(), amount, rounded));
        }

        return result;
    }

}
