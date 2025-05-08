package com.fastcampus.Res9ueTeam.dto;

import com.fastcampus.Res9ueTeam.entity.Category;
import com.fastcampus.Res9ueTeam.entity.CategoryType;
import com.fastcampus.Res9ueTeam.entity.PaymentType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MoneyRecordRequestDto {

    private Long userId;
    private int amount;
    private Category category;
    private CategoryType categoryType;
    private PaymentType paymentType;
    private LocalDate recordDate;

}