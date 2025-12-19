package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}
