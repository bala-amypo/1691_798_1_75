package com.example.demo.service.impl;

import com.example.demo.entity.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository ruleRepository;

    public RiskRuleServiceImpl(RiskRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public RiskRule createRule(RiskRule rule) {
        if (ruleRepository.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule name must be unique");
        }
        return ruleRepository.save(rule);
    }

    @Override
    public List<RiskRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public RiskRule getRule(Long id) {
        return ruleRepository.findById(id).orElseThrow();
    }
}

