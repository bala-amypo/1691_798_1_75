package com.example.demo.service.impl;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository scoreAuditLogRepository;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository scoreAuditLogRepository) {
        this.scoreAuditLogRepository = scoreAuditLogRepository;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        return scoreAuditLogRepository.save(log);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return scoreAuditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return scoreAuditLogRepository.findAll();
    }
}
















// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.ScoreAuditLogService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

//     private final ScoreAuditLogRepository auditLogRepository;
//     private final VisitorRepository visitorRepository;
//     private final RiskRuleRepository riskRuleRepository;

//     @Override
//     public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {

//         if (log.getReason() == null || log.getReason().isBlank()) {
//             throw new IllegalArgumentException("reason required");
//         }

//         Visitor visitor = visitorRepository.findById(visitorId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

//         RiskRule rule = riskRuleRepository.findById(ruleId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

//         log.setVisitor(visitor);
//         log.setAppliedRule(rule);

//         return auditLogRepository.save(log);
//     }

//     @Override
//     public ScoreAuditLog getLog(Long id) {
//         return auditLogRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Score audit log not found"));
//     }

//     @Override
//     public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
//         return auditLogRepository.findByVisitorId(visitorId);
//     }
// }
