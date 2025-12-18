package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Visitor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String fullName;
private String email;
private String phone;
private String idProof;
private LocalDateTime createdAt;


@PrePersist
void prePersist() {
if (phone == null || phone.isBlank()) {
throw new IllegalArgumentException("phone required");
}
createdAt = LocalDateTime.now();
}
}

