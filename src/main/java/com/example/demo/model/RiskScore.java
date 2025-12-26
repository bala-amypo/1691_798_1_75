package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalScore;

    private String riskLevel;

    @OneToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;
}









// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "risk_scores")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class RiskScore {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "visitor_id", nullable = false, unique = true)
//     private Visitor visitor;

//     @Column(nullable = false)
//     private Integer totalScore;

//     @Column(nullable = false)
//     private String riskLevel;

//     private LocalDateTime evaluatedAt;

//     @PrePersist
//     public void prePersist() {
//         this.evaluatedAt = LocalDateTime.now();
//     }
// }
