package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository ruleRepository;
    private final ScoreAuditLogRepository logRepository;

    public ScoreAuditLogServiceImpl(
            VisitorRepository visitorRepository,
            RiskRuleRepository ruleRepository,
            ScoreAuditLogRepository logRepository) {
        this.visitorRepository = visitorRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        log.setVisitor(visitorRepository.findById(visitorId).orElseThrow());
        log.setAppliedRule(ruleRepository.findById(ruleId).orElseThrow());
        return logRepository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return logRepository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return logRepository.findById(id).orElseThrow();
    }
}
