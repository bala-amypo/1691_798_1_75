package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;   //  REQUIRED

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private Set<String> roles;
}
