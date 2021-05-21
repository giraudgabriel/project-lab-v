package com.fatec.sp.gov.br.gta.service;

import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.entity.Group;
import com.fatec.sp.gov.br.gta.entity.BankCharacter;
import com.fatec.sp.gov.br.gta.repository.CharacterRepository;
import com.fatec.sp.gov.br.gta.repository.BankCharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private BankCharacterRepository bankRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Character create(String name, String password) {

        Character character = characterRepo.findCharacterByName(name);
        if (character == null) {
            // character
            character = new Character();
            character.setName(name);
            character.setPassword(passwordEncoder.encode(password));
            characterRepo.save(character);

            // bank
            BankCharacter bank = new BankCharacter();
            bank.setBalance(5000L);
            bank.setCharacter(character);
            bankRepo.save(bank);

            character.setBank(bank);
        }

        return character;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Optional<Character> update(String name, Long id) {
        characterRepo.updateCharacter(name, id);
        Optional<Character> character = characterRepo.findById(id);
        if (character.isPresent()) {
            return character;
        }
        return null;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
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

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'POLICIA')")
    public List<Character> getAllDto() {
        List<Character> characterList = characterRepo.findAll();
        return characterList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Character character = characterRepo.findCharacterByName(username);
        if (character == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(character.getPassword())
                .authorities(character.getGroups().stream().map(Group::getRole).collect(Collectors.toList())
                        .toArray(new String[character.getGroups().size()]))
                .build();
    }
}
