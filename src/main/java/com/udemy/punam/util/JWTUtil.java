package com.udemy.punam.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil
{
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);    public String generateToken(String username){
        JwtBuilder jwt = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 *60*60 *10))
                .signWith(SignatureAlgorithm.HS256,key);

        return jwt.compact();
    }
}
