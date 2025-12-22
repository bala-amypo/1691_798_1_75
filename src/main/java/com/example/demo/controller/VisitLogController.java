package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
@RequiredArgsConstructor
@Tag(name = "Visit Logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLog> createLog(
            @PathVariable Long visitorId,
            @RequestBody VisitLog log
    ) {
        return ResponseEntity.ok(visitLogService.createVisitLog(visitorId, log));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(visitLogService.getLogsByVisitor(visitorId));
    }
}
