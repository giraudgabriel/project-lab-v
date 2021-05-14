package com.fatec.sp.gov.br.gta.security;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    private static final String secretKey = "spring.jwt.sec";

    public static String generateToken(Authentication user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Login userWithoutPass = new Login();
        userWithoutPass.setUsername(user.getName());
        if (!user.getAuthorities().isEmpty()) {
            userWithoutPass.setRoles(user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()).toArray(new String[user.getAuthorities().size()]));
        }
        String userJson = mapper.writeValueAsString(user);
        Date agora = new Date();
        Long hora = 1000L * 60L * 60L;
        return Jwts.builder().claim("userDetails", userJson).setIssuer("br.gov.sp.fatec").setSubject(user.getName())
                .setExpiration(new Date(agora.getTime() + hora)).signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public static Character parseToken(String token) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody()
                .get("userDetails", String.class);
        return mapper.readValue(credentialsJson, Character.class);
    }
}
