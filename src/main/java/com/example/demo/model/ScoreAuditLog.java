package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer scoreChange;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private RiskRule rule;
}











// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "score_audit_logs")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class ScoreAuditLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "visitor_id", nullable = false)
//     private Visitor visitor;

//     @ManyToOne
//     @JoinColumn(name = "rule_id", nullable = false)
//     private RiskRule appliedRule;

//     @Column(nullable = false)
//     private Integer scoreChange;

//     @Column(nullable = false)
//     private String reason;

//     private LocalDateTime loggedAt;

//     @PrePersist
//     public void prePersist() {
//         this.loggedAt = LocalDateTime.now();
//     }
// }
