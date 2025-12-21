package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;

import java.util.List;

public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository repository;

    public RiskRuleServiceImpl(RiskRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskRule createRule(RiskRule rule) {
        repository.findByRuleName(rule.getRuleName())
                .ifPresent(r -> {
                    throw new BadRequestException("Rule name must be unique");
                });
        return repository.save(rule);
    }

    @Override
    public List<RiskRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public RiskRule getRule(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));
    }
}
