package com.fastcampus.Res9ueTeam.dto;

import com.fastcampus.Res9ueTeam.entity.Goal;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GoalResponseDto {

    private Long expenseGoal;
    private Long saveGoal;
    private String resolution;
    private LocalDate goalDate;

    public static GoalResponseDto fromEntity(Goal goal) {
        return GoalResponseDto.builder()
                .expenseGoal(goal.getExpenseGoal())
                .saveGoal(goal.getSaveGoal())
                .resolution(goal.getResolution())
                .goalDate(goal.getGoalDate())
                .build();
    }

}
