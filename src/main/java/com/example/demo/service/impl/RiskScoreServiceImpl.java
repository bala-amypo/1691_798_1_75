package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.RiskScore;
import com.example.demo.entity.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
// import com.example.demo.util.RiskLevelUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        int score = 0; // scoring logic placeholder

        RiskScore riskScore = riskScoreRepository
                .findByVisitorId(visitorId)
                .orElse(RiskScore.builder().visitor(visitor).build());

        riskScore.setTotalScore(Math.max(score, 0));
        riskScore.setRiskLevel(RiskLevelUtils.determineRiskLevel(score));

        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk score not found"));
    }

    @Override
    public java.util.List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
