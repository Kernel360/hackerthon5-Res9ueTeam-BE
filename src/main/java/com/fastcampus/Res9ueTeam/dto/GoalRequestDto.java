package com.fastcampus.Res9ueTeam.dto;

import com.fastcampus.Res9ueTeam.entity.Goal;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GoalRequestDto {

    private Long userId;
    private Long expenseGoal;
    private Long saveGoal;
    private String resolution;
    private LocalDate goalDate;

    public Goal toEntity() {
        return Goal.builder()
                .userId(this.userId)
                .expenseGoal(this.expenseGoal)
                .saveGoal(this.saveGoal)
                .resolution(this.resolution)
                .goalDate(this.goalDate)
                .build();
    }



}
