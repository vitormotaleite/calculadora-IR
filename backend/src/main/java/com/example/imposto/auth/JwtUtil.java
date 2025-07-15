package com.example.imposto.auth;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    private static final String SECRET_STRING = "7IDaRAqzvb3fhxX/4U0RJ/UX3nTzPg+TOb6ZzIuQd9rsAqIZ3Fd+KGoZ5vIsqCgVqwbYyO9i9oI8p4EdFqz44A==";
    private static final Key SECRET = new SecretKeySpec(Base64.getDecoder().decode(SECRET_STRING), SignatureAlgorithm.HS512.getJcaName());
    private static final long SECRET_EXPIRATION_TIME = 86400000;

    public static String gerarToken(String username) {
        return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + SECRET_EXPIRATION_TIME)).
        signWith(SECRET, SignatureAlgorithm.HS512).compact();
    }

    public static String validarToken(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token).getBody().getSubject();
    }

}
