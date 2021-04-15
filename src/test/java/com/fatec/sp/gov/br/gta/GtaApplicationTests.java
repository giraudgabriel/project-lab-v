package com.fatec.sp.gov.br.gta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.repository.GroupRepository;
import com.fatec.sp.gov.br.gta.repository.CharacterRepository;
import com.fatec.sp.gov.br.gta.service.CharacterService;
import com.fatec.sp.gov.br.gta.service.CharacterServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class gtaApplicationTests {

    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private GroupRepository groupRepo;

    @Autowired
    private CharacterService characterService;

    
    @Test
    void testaBusca(){
        assertEquals("", "");
    }
}
