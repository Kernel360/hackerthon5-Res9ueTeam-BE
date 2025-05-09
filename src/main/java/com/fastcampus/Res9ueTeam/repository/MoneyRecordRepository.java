package com.fastcampus.Res9ueTeam.repository;

import com.fastcampus.Res9ueTeam.entity.MoneyRecord;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface MoneyRecordRepository extends JpaRepository<MoneyRecord, Long> {

    @Query("SELECT m FROM MoneyRecord m WHERE m.userId = :user_id")
    List<MoneyRecord> findByUserAndTypeAndDateRange(
            @Param("user_id") Long user_id
    );

    List<MoneyRecord> findByUserId(Long userId);

    @Query("SELECT m FROM MoneyRecord m " +
            "WHERE m.userId = :user_id " +
            "AND m.recordDate BETWEEN :startOfMonth AND :endOfMonth")
    List<MoneyRecord> findByUserIdAndIdInMonth(
            @Param("user_id") Long user_id,
            @Param("startOfMonth") LocalDate startOfMonth,
            @Param("endOfMonth") LocalDate endOfMonth
    );
}
