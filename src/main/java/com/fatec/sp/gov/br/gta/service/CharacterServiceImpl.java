package com.fatec.sp.gov.br.gta.service;

import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.repository.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("characterService")
public class CharacterServiceImpl implements CharacterService {

    @Autowired 
    private CharacterRepository characterRepo;
    

    @Override
    @Transactional
    public Character adicionarCharacter(String name) {

        Character character = new Character();
        character.setName(name);
        characterRepo.save(character);
        return character;
    }
    
}
