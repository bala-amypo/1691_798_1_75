package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private Set<String> roles;
}
