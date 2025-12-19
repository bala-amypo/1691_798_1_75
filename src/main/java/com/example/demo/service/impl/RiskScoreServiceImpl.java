package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository ruleRepository;
    private final RiskScoreRepository scoreRepository;
    private final ScoreAuditLogRepository auditLogRepository;

    public RiskScoreServiceImpl(
            VisitorRepository visitorRepository,
            RiskRuleRepository ruleRepository,
            RiskScoreRepository scoreRepository,
            ScoreAuditLogRepository auditLogRepository) {
        this.visitorRepository = visitorRepository;
        this.ruleRepository = ruleRepository;
        this.scoreRepository = scoreRepository;
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElseThrow();
        List<RiskRule> rules = ruleRepository.findAll();

        int totalScore = 0;

        for (RiskRule rule : rules) {
            totalScore += rule.getScoreImpact();

            auditLogRepository.save(
                ScoreAuditLog.builder()
                    .visitor(visitor)
                    .appliedRule(rule)
                    .scoreChange(rule.getScoreImpact())
                    .reason("Applied rule: " + rule.getRuleName())
                    .build()
            );
        }

        RiskScore score = RiskScore.builder()
                .visitor(visitor)
                .totalScore(totalScore)
                .riskLevel(RiskLevelUtils.determineRiskLevel(totalScore))
                .evaluatedAt(LocalDateTime.now())
                .build();

        return scoreRepository.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return scoreRepository.findByVisitorId(visitorId).orElseThrow();
    }

    @Override
    public List<RiskScore> getAllScores() {
        return scoreRepository.findAll();
    }
}

