package com.example.demo.controller;

import com.example.demo.entity.RiskScore;
import com.example.demo.service.RiskScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
@Tag(name = "Risk Scores")
public class RiskScoreController {

    private final RiskScoreService service;

    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{visitorId}")
    public RiskScore evaluate(@PathVariable Long visitorId) {
        return service.evaluateVisitor(visitorId);
    }

    @GetMapping("/{visitorId}")
    public RiskScore get(@PathVariable Long visitorId) {
        return service.getScoreForVisitor(visitorId);
    }

    @GetMapping
    public List<RiskScore> list() {
        return service.getAllScores();
    }
}
