package com.fatec.sp.gov.br.gta.repository;
import java.util.Set;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharacterRepository extends JpaRepository<Character,Long>{
    public Character findCharacterByName(String name);
}