package com.fastcampus.Res9ueTeam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponseDto {
    private String categoryName;
    private Long totalAmount;
    private double percentage;
}
