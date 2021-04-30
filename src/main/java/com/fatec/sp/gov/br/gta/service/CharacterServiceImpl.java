package com.fatec.sp.gov.br.gta.service;
import java.util.HashSet;

import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;
import com.fatec.sp.gov.br.gta.repository.CharacterRepository;
import com.fatec.sp.gov.br.gta.repository.BankCharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.List;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService {

    @Autowired 
    private CharacterRepository characterRepo;

    @Autowired 
    private BankCharacterRepository bankRepo;

    @Override
    @Transactional
    public Character create(String name) {

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
    
    @Override
    public Optional<Character> update(String name, Long id) {
        characterRepo.updateCharacter(name, id);
        Optional<Character> character = characterRepo.findById(id);
        if(character.isPresent()){
            return character;
        }
        return null;
    }

    @Override
    public Optional<Character> delete(Long id) {
        Optional<Character> character = characterRepo.findById(id);
        characterRepo.deleteCharacter(id);
        return character;
    }

    @Override
    public List<Character> getAll() {
        List<Character> characterList = characterRepo.findAll();
        return characterList;
    }

}
