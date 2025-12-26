package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JwtTokenProvider {

    // ====== Used in tests (mocked) ======
    public String createToken(Long userId, String email, Set<String> roles) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public Claims getClaims(String token) {
        return Jwts.claims().setSubject("test@example.com");
    }
}










// package com.example.demo.security;

// import com.example.demo.entity.User;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private static final String SECRET_KEY = "my-secret-key";
//     private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 1 day

//     public String generateToken(User user) {

//         return Jwts.builder()
//                 .setSubject(user.getEmail())
//                 .claim("roles", user.getRoles())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                 .compact();
//     }
// }
