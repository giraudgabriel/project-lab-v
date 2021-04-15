package com.fatec.sp.gov.br.gta.repository;
import java.util.Set;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankCharacterRepository extends JpaRepository<BankCharacter,Long>{
    public BankCharacter findBankCharacterByCharacter(Character character);
}
