package br.com.issler.acheiQI.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;

@Component
public class TokenProvider {
    @Value("${jwt.key}")
    private String key;

    public String generate(Authentication auth){
        UserDetails user = (UserDetails) auth.getPrincipal();
        return build(Objects.requireNonNull(user).getUsername());
    }

    private String build(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(key.getBytes());
    }
}
