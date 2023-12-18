package com.cee.tech.api;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Map;

public class TestJwt {
    public static void main(String[] args) {

        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);


        String username = "exampleUsername";

        String jwt = Jwts.builder()
                .claim("username", username)
                .signWith(key)
                .compact();

        System.out.println(jwt);
    }
}
