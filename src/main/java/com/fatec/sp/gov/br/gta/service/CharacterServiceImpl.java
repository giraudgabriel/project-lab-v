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

    @Autowired 
    private BankCharacterRepository bankRepo;

    @Override
    @Transactional
    public Character adicionarCharacter(String name) {

        Character character = characterRepo.findCharacterByName(name);
        if(character == null){
            //character
            character = new Character();
            character.setName(name);
            characterRepo.save(character);

            //bank
            BankCharacter bank = new BankCharacter();
            bank.setBalance(5000L);
            bank.setCharacter(character);
            bankRepo.save(bank);

            character.setBank(bank);
        }
        
        return character;
    }
    
}
