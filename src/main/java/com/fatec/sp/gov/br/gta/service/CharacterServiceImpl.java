package com.fatec.sp.gov.br.gta.service;
import java.util.HashSet;

import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;
import com.fatec.sp.gov.br.gta.repository.CharacterRepository;
import com.fatec.sp.gov.br.gta.repository.BankCharacterRepository;

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

        //bank
        BankCharacter bank = new BankCharacter();
        bank.setBalance(5000L);
        
        //character
        Character character = new Character();
        character.setName(name);
        character.setBanks(new HashSet<BankCharacter>());
        character.getBanks().add(bank);
        characterRepo.save(character);
        return character;
    }
    
}
