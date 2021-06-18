package com.fatec.sp.gov.br.gta.controller;

import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fatec.sp.gov.br.gta.security.JwtUtils;
import com.fatec.sp.gov.br.gta.security.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping()
    public Login auth(@RequestBody Login login) {
        Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        auth = authManager.authenticate(auth);
        try {
            login.setToken(JwtUtils.generateToken(auth));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        login.setRoles(auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())
                .toArray(new String[auth.getAuthorities().size()]));
        login.setPassword(null);
        return login;
    }
}
