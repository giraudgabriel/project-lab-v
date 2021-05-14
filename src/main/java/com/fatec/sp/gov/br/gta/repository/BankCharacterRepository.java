package com.fatec.sp.gov.br.gta.repository;
import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCharacterRepository extends JpaRepository<BankCharacter,Long>{
    public BankCharacter findBankCharacterByCharacter(Character character);
}
