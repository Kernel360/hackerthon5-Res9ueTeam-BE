package com.fastcampus.Res9ueTeam.entity;

import com.fastcampus.Res9ueTeam.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class MoneyRecord extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private Integer amount;

    private LocalDate recordDate;

    public MoneyRecord(Long userId, Category category, CategoryType categoryType,
                       PaymentType paymentType, Integer amount, LocalDate recordDate) {
        this.userId = userId;
        this.category = category;
        this.categoryType = categoryType;
        this.paymentType = paymentType;
        this.amount = amount;
        this.recordDate = recordDate;
    }
}
