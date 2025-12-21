package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Score Audit Logs")
@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService auditLogService;

    public ScoreAuditLogController(ScoreAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ScoreAuditLog createLog(@PathVariable Long visitorId,
                                   @PathVariable Long ruleId,
                                   @RequestBody ScoreAuditLog log) {
        return auditLogService.logScoreChange(visitorId, ruleId, log);
    }

    @GetMapping("/{id}")
    public ScoreAuditLog getLog(@PathVariable Long id) {
        return auditLogService.getLog(id);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<ScoreAuditLog> getLogsByVisitor(@PathVariable Long visitorId) {
        return auditLogService.getLogsByVisitor(visitorId);
    }
}
