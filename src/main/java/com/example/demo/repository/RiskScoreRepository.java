package com.example.demo.repository;

import com.example.demo.model.RiskScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {

    Optional<RiskScore> findByVisitorId(Long visitorId);
}






// package com.example.demo.repository;

// import com.example.demo.entity.RiskScore;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// @Repository
// public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {

//     Optional<RiskScore> findByVisitorId(Long visitorId);
// }
