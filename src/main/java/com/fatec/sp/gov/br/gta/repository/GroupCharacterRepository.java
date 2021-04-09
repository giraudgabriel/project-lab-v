package com.fatec.sp.gov.br.gta.repository;

import java.util.Set;

import com.fatec.sp.gov.br.gta.entity.GroupCharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupCharacterRepository extends JpaRepository<GroupCharacter,Long>{
    
   
}
