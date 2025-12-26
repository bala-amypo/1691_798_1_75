package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phone;

    private String email;

    private String idProof;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL)
    private List<VisitLog> visitLogs;

    @OneToOne(mappedBy = "visitor", cascade = CascadeType.ALL)
    private RiskScore riskScore;
}







// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "visitors")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Visitor {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String fullName;

//     @Column(unique = true)
//     private String email;

//     @Column(nullable = false)
//     private String phone;

//     @Column(nullable = false)
//     private String idProof;

//     private LocalDateTime createdAt;

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//     }
// }
