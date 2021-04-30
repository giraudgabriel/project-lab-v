package com.fatec.sp.gov.br.gta.service;

import com.fatec.sp.gov.br.gta.entity.Character;
import java.util.Optional;
import java.util.List;

public interface CharacterService {
    public Character create(String name);

    public Optional<Character> update(String name, Long id);

    public Optional<Character> delete(Long id);
    
    public List<Character> getAll();
}
