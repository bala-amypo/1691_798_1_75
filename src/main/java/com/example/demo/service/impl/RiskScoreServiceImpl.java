package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskRule;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;

import java.util.List;

public class RiskScoreServiceImpl implements RiskScoreService {

    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository ruleRepository;
    private final RiskScoreRepository scoreRepository;

    public RiskScoreServiceImpl(VisitorRepository visitorRepository,
                                RiskRuleRepository ruleRepository,
                                RiskScoreRepository scoreRepository) {
        this.visitorRepository = visitorRepository;
        this.ruleRepository = ruleRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        int totalScore = 0;
        List<RiskRule> rules = ruleRepository.findAll();

        for (RiskRule rule : rules) {
            totalScore += Math.max(rule.getScoreImpact(), 0);
        }

        String riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);

        RiskScore score = RiskScore.builder()
                .visitor(visitor)
                .totalScore(totalScore)
                .riskLevel(riskLevel)
                .build();

        return scoreRepository.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return scoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskScore not found"));
    }

    @Override
    public List<RiskScore> getAllScores() {
        return scoreRepository.findAll();
    }
}
