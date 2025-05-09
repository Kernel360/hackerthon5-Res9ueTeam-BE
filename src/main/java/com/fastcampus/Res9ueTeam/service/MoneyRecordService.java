package com.fastcampus.Res9ueTeam.service;

import com.fastcampus.Res9ueTeam.dto.MoneyRecordRequestDto;
import com.fastcampus.Res9ueTeam.dto.MoneyRecordResponseDto;
import com.fastcampus.Res9ueTeam.entity.MoneyRecord;
import com.fastcampus.Res9ueTeam.repository.MoneyRecordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoneyRecordService {

    private final MoneyRecordRepository moneyRecordRepository;

    public List<MoneyRecordResponseDto> getPayment(MoneyRecordRequestDto dto) {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);

        List<MoneyRecord> moneyRecords = moneyRecordRepository.findByUserAndTypeAndDateRange(
                dto.getUserId()
        );

        return moneyRecords.stream()
                .map(MoneyRecordResponseDto::from)
                .toList();
    }

    public List<MoneyRecordResponseDto> getMonthlyRecord(Long userId, LocalDate recordDate){
        LocalDate startOfMonth = recordDate.withDayOfMonth(1);
        LocalDate endOfMonth = recordDate.withDayOfMonth(recordDate.lengthOfMonth());

        List<MoneyRecord> records = moneyRecordRepository.findByUserIdAndIdInMonth(userId, startOfMonth, endOfMonth);
        return records.stream()
                .map(MoneyRecordResponseDto::from)
                .toList();
    }

    @Transactional
    public void savePayment(MoneyRecordRequestDto dto) {
        MoneyRecord moneyRecord = new MoneyRecord(
                dto.getUserId(),
                dto.getCategory(),
                dto.getCategoryType(),
                dto.getPaymentType(),
                dto.getAmount(),
                dto.getRecordDate()
        );

        moneyRecordRepository.save(moneyRecord);
    }

    @Transactional
    public void deletePayment(Long id) {
        moneyRecordRepository.deleteById(id);
    }
}