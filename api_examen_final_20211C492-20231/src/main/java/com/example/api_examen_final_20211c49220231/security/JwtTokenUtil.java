package com.example.api_examen_final_20211c49220231.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Clase 1
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    //milisegundos || 18 minutos, le quitamos mil 18 segundos demo
    public static final long ycqtJWT_TOKEN_VALIDITY = 7 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String ycqtSecret;

    public String ycqtGetUsernameFromToken(String token) {
        return ycqtGetClaimFromToken(token, Claims::getSubject);
    }

    public Date ycqtGetExpirationDateFromToken(String token) {
        return ycqtGetClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T ycqtGetClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = ycqtGetAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims ycqtGetAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(ycqtSecret).parseClaimsJws(token).getBody();
    }

    private Boolean ycqtIsTokenExpired(String token) {
        final Date expiration = ycqtGetExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String ycqtGenerateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", "rosa");
        claims.put("role", userDetails.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.joining()));
        return ycqtDoGenerateToken(claims, userDetails.getUsername());
    }

    private String ycqtDoGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ycqtJWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, ycqtSecret).compact();
    }

    public Boolean ycqtValidateToken(String token, UserDetails userDetails) {
        final String username = ycqtGetUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !ycqtIsTokenExpired(token));
    }
}