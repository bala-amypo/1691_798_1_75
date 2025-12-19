package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
@Tag(name = "Visit Logs")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}")
    public VisitLog create(
            @PathVariable Long visitorId,
            @RequestBody VisitLog log) {
        return service.createVisitLog(visitorId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<VisitLog> list(@PathVariable Long visitorId) {
        return service.getLogsByVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public VisitLog get(@PathVariable Long id) {
        return service.getLog(id);
    }
}
