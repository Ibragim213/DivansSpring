package com.example.reviews.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = Base64.getEncoder().encodeToString("s2a23kn5ln5k3nlk46jn6342k4lk634k6jkhn1325mlk45643".getBytes());
    private static final long EXPIRATION_TIME = 86400000; // 24 часа

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, Base64.getDecoder().decode(SECRET_KEY))
                .compact();
    }

    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
