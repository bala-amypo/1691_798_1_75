package com.example.demo.service;

import com.example.demo.model.RiskRule;
import java.util.List;

public interface RiskRuleService {

    RiskRule createRule(RiskRule rule);

    RiskRule getRule(Long id);

    List<RiskRule> getAllRules();
}










// package com.example.demo.service;

// import com.example.demo.entity.RiskRule;

// import java.util.List;

// public interface RiskRuleService {

//     RiskRule createRule(RiskRule rule);

//     RiskRule getRule(Long id);

//     List<RiskRule> getAllRules();
// }
