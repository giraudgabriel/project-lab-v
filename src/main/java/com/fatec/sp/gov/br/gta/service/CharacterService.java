package com.fatec.sp.gov.br.gta.service;

import com.fatec.sp.gov.br.gta.entity.Character;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;
import java.util.List;

public interface CharacterService extends UserDetailsService{
    public Character create(String name, String password);

    public Optional<Character> update(String name, Long id);

    public Optional<Character> delete(Long id);
    
    public List<Character> getAll();

    public List<Character> getAllDto();
}
