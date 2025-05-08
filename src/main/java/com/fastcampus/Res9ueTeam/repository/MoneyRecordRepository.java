package com.fastcampus.Res9ueTeam.repository;

import com.fastcampus.Res9ueTeam.entity.MoneyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoneyRecordRepository extends JpaRepository<MoneyRecord, Long> {

    List<MoneyRecord> findByUserId(Long userId);

    MoneyRecord findByUserId2(String userId);
}
