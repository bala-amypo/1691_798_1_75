package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score-logs")
@RequiredArgsConstructor
@Tag(name = "Score Audit Logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> createLog(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log
    ) {
        return ResponseEntity.ok(
                scoreAuditLogService.logScoreChange(visitorId, ruleId, log)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(scoreAuditLogService.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(scoreAuditLogService.getLogsByVisitor(visitorId));
    }
}
