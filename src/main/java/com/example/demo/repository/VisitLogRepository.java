package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    // REQUIRED BY TESTS – DO NOT RENAME
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    // REQUIRED BY TESTS – DO NOT RENAME
    long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}
