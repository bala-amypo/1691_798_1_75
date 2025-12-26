package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String ruleType;

    private Integer threshold;

    private Integer scoreImpact;
}







// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(
//     name = "risk_rules",
//     uniqueConstraints = @UniqueConstraint(columnNames = "ruleName")
// )
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class RiskRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String ruleName;

//     @Column(nullable = false)
//     private String ruleType; // AFTER_HOURS, FREQUENT_VISITS, etc.

//     @Column(nullable = false)
//     private Integer threshold;

//     @Column(nullable = false)
//     private Integer scoreImpact;

//     private LocalDateTime createdAt;

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//     }
// }
