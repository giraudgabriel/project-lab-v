package com.fatec.sp.gov.br.gta.repository;
import java.util.Set;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.entity.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group,Long>{
    @Query("SELECT g.characters from Group g inner join g.characters where g.code = ?1")
    public Set<Character> findCharactersFromGroupCode(String code);

    @Query("SELECT g.characters from Group g inner join g.characters where g.name = ?1")
    public Set<Character> findCharactersFromGroupName(String name);

    public Group findGroupByName(String name);

    public Group findGroupByCode(String code);

    public Group findGroupByCodeAndName(String code, String name);
}
