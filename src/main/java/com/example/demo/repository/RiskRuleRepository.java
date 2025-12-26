package com.example.demo.repository;

import com.example.demo.model.RiskRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {

    Optional<RiskRule> findByRuleName(String ruleName);
}





// package com.example.demo.repository;

// import com.example.demo.entity.RiskRule;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// @Repository
// public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {

//     Optional<RiskRule> findByRuleName(String ruleName);
// }
