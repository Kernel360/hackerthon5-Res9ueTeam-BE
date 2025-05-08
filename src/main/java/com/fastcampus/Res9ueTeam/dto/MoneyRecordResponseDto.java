package com.fastcampus.Res9ueTeam.dto;

import com.fastcampus.Res9ueTeam.entity.Category;
import com.fastcampus.Res9ueTeam.entity.CategoryType;
import com.fastcampus.Res9ueTeam.entity.MoneyRecord;
import com.fastcampus.Res9ueTeam.entity.PaymentType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MoneyRecordResponseDto {

    private Long userId;
    private int amount;
    private Category category;
    private CategoryType categoryType;
    private PaymentType paymentType;
    private LocalDate recordDate;

    public static MoneyRecordResponseDto from(MoneyRecord moneyRecord) {
        return new MoneyRecordResponseDto(
                moneyRecord.getUserId(),
                moneyRecord.getAmount(),
                moneyRecord.getCategory(),
                moneyRecord.getCategoryType(),
                moneyRecord.getPaymentType(),
                moneyRecord.getRecordDate()
        );
    }
}
