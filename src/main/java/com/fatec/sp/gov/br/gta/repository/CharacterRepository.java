package com.fatec.sp.gov.br.gta.repository;
import java.util.Set;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character,Long>{
    public Character findCharacterByName(String name);
    
    @Transactional
    @Modifying
    @Query("UPDATE Character c set c.name = ?1 where c.id = ?2")
    public void updateCharacter(String name, Long id);

    @Transactional
    @Modifying
    @Query("DELETE Character c where c.id = ?1")
    public void deleteCharacter(Long id);
}