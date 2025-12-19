package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
    List<ScoreAuditLog> findByVisitorId(Long visitorId);
}
