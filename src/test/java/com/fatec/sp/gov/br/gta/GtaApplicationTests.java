package com.fatec.sp.gov.br.gta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;
import com.fatec.sp.gov.br.gta.repository.GroupRepository;
import com.fatec.sp.gov.br.gta.repository.CharacterRepository;
import com.fatec.sp.gov.br.gta.repository.BankCharacterRepository;
import com.fatec.sp.gov.br.gta.service.CharacterService;
import com.fatec.sp.gov.br.gta.service.CharacterServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class gtaApplicationTests {

    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private GroupRepository groupRepo;

    @Autowired
    private BankCharacterRepository bankRepo;


    @Autowired
    private CharacterService characterService;

    
    @Test
    void testaInserirCharacter(){
        Character character = characterService.adicionarCharacter("Ronaldo");
        assertNotNull(character.getId());
        assertNotNull(character.getBank());
        assertEquals(5000L,character.getBank().getBalance());
        assertNotNull(character.getBank().getId());

    }

    @Test
    void testaBuscarCharacterPorNome(){
        Character character = characterRepo.findCharacterByName("Giraud");
        assertNotNull(character.getId());
    }

    @Test
    void testaBuscarGroupPorNome(){
        Group group = groupRepo.findGroupByName("Polícia");
        assertNotNull(group.getId());
    }

    @Test
    void testaBuscarGroupPorCode(){
        Group group = groupRepo.findGroupByCode("policia");
        assertNotNull(group.getId());
    }

    @Test
    void testaBuscarGroupPorCodeAndName(){
        Group group = groupRepo.findGroupByCodeAndName("policia", "Polícia");
        assertNotNull(group.getId());
    }

    @Test
    void testaBuscarCharactersPorGroupCode(){
        Set<Character> characters = groupRepo.findCharactersFromGroupCode("policia");
        assertNotNull(characters);
    }

    @Test
    void testaBuscarCharactersPorGroupName(){
        Set<Character> characters = groupRepo.findCharactersFromGroupName("Polícia");
        assertNotNull(characters);
    }

    @Test
    void testaBuscarBankPorCharacter(){
        Character character = characterRepo.findCharacterByName("Giraud");
        assertNotNull(character.getId());
        BankCharacter bank = bankRepo.findBankCharacterByCharacter(character);
        assertNotNull(bank.getId());
    }

}
