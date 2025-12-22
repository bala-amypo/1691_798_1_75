package com.example.demo.controller;

import com.example.demo.enity.RiskRule;
import com.example.demo.service.RiskRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
@RequiredArgsConstructor
@Tag(name = "Risk Rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    @PostMapping
    public ResponseEntity<RiskRule> createRule(@RequestBody RiskRule rule) {
        return ResponseEntity.ok(riskRuleService.createRule(rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(riskRuleService.getRule(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskRule>> getAllRules() {
        return ResponseEntity.ok(riskRuleService.getAllRules());
    }
}
