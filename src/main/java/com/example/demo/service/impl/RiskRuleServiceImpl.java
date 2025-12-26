package com.example.demo.service.impl;

import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository riskRuleRepository;

    public RiskRuleServiceImpl(RiskRuleRepository riskRuleRepository) {
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public RiskRule createRule(RiskRule rule) {
        return riskRuleRepository.save(rule);
    }

    @Override
    public RiskRule getRule(Long id) {
        return riskRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<RiskRule> getAllRules() {
        return riskRuleRepository.findAll();
    }
}



















// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.entity.RiskRule;
// import com.example.demo.repository.RiskRuleRepository;
// import com.example.demo.service.RiskRuleService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class RiskRuleServiceImpl implements RiskRuleService {

//     private final RiskRuleRepository riskRuleRepository;

//     @Override
//     public RiskRule createRule(RiskRule rule) {
//         riskRuleRepository.findByRuleName(rule.getRuleName())
//                 .ifPresent(r -> {
//                     throw new IllegalArgumentException("Rule name must be unique");
//                 });

//         return riskRuleRepository.save(rule);
//     }

//     @Override
//     public RiskRule getRule(Long id) {
//         return riskRuleRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Risk rule not found"));
//     }

//     @Override
//     public List<RiskRule> getAllRules() {
//         return riskRuleRepository.findAll();
//     }
// }
