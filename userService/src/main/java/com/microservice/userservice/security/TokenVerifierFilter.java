package com.microservice.userservice.security;

import com.microservice.userservice.entity.Claim;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TokenVerifierFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if(Strings.hasText(token) && token.startsWith("Bearer ")) {
            token = token.substring(7);
            String key = "secret_secret_secret_secret_secret_secret_secret_secret_secret";
            try{
                Jws<Claims> jwsClaims = Jwts.parser()
                        .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                        .parseClaimsJws(token);

                Claims body = jwsClaims.getBody();
                String email = body.getSubject();

                List<Map<String,String>> authorities = (List<Map<String, String>>) body.get("authorities");

                Set<SimpleGrantedAuthority> grantedAuthorities = authorities.stream()
                        .map(a ->
                                new SimpleGrantedAuthority("ROLE_" + a.get("authority"))
                        ).collect(Collectors.toSet());

                Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, grantedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            }catch (JwtException e){
                throw new RuntimeException("Token is not valid!");
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }
}
