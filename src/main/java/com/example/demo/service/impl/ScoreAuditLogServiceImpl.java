package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskRule;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.ScoreAuditLogService;

import java.util.List;

public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository logRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository ruleRepository;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository logRepository,
                                    VisitorRepository visitorRepository,
                                    RiskRuleRepository ruleRepository) {
        this.logRepository = logRepository;
        this.visitorRepository = visitorRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        if (log.getReason() == null || log.getReason().isBlank()) {
            throw new BadRequestException("reason required");
        }

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        RiskRule rule = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));

        log.setVisitor(visitor);
        log.setAppliedRule(rule);

        return logRepository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return logRepository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ScoreAuditLog not found"));
    }
}
