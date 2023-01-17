package com.cts.authorization.filter;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
        private final String SECRET_KEY = "secret";

        public String extractUsername(String token) {
             return extractClaim(token, Claims::getSubject);
        }

        public Date extractExpiration(String token) {
            return extractClaim(token, Claims::getExpiration);
        }

        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }
        private Claims extractAllClaims(String token) {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        }

        private Boolean isTokenExpired(String token) {
            return extractExpiration(token).before(new Date());
        }

        public String generateToken(UserDetails userDetails) {
            Map<String, Object> claims = new HashMap<>();
            return createToken(claims, userDetails);
        }

        private String createToken(Map<String, Object> claims, UserDetails userDetails) {
            SignatureAlgorithm algorithm=SignatureAlgorithm.HS256;
          String access_token=   Jwts.builder()
                 .setClaims(claims)
                 .setSubject(userDetails.getUsername())
                 .claim("authorities",userDetails.getAuthorities())
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                 .signWith(algorithm,SECRET_KEY).compact();
          return access_token;
        /*  String refresh_token=Jwts.builder()
                  .setClaims(claims)
                  .setSubject(userDetails.getUsername())
                  .claim("authorities",userDetails.getAuthorities())
                  .setIssuedAt(new Date(System.currentTimeMillis()))
                  .setExpiration(new Date(System.currentTimeMillis()+7*24*60*60*1000))
                  .signWith(algorithm,SECRET_KEY).compact();
              HashMap<String ,String>token=new HashMap<>();
              token.put("access_token",access_token);
              token.put("refresh_token",refresh_token);
            token.*/
        }

        public Boolean validateToken(String token, UserDetails userDetails) {
            final String username = extractUsername(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }

}
