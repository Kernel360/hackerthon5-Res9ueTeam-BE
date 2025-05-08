package com.fastcampus.Res9ueTeam.repository;

import com.fastcampus.Res9ueTeam.entity.MoneyRecord;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface MoneyRecordRepository extends JpaRepository<MoneyRecord, Long> {

    @Query("SELECT m FROM MoneyRecord m WHERE m.userId = :userId")
    List<MoneyRecord> findByUserAndTypeAndDateRange(
            @Param("userId") Long userId
    );
}