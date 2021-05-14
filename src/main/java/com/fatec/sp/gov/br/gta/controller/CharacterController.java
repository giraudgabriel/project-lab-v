package com.fatec.sp.gov.br.gta.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.gta.entity.Character;
import com.fatec.sp.gov.br.gta.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/character")
@CrossOrigin
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/")
    @JsonView(View.CharacterMain.class)
    public List<Character> get(){
        return characterService.getAll();
    }

    @GetMapping(value = "/all")
    @JsonView(View.CharacterDto.class)
    public List<Character> getAll(){
        return characterService.getAllDto();
    }

    @PostMapping
    @JsonView(View.CharacterMain.class)
    public Character create(@RequestBody Character character){ 
        return characterService.create(character.getName(), character.getPassword());
    }

    @PutMapping(value = "/{id}")
    @JsonView(View.CharacterDto.class)
    public Optional<Character> update(@PathVariable(value = "id") Long id, @RequestParam(value = "name") String name){
        return characterService.update(name, id);

    }

    @DeleteMapping(value = "/{id}")
    @JsonView(View.CharacterDto.class)
    public Optional<Character> delete(@PathVariable(value ="id") Long id){

        return characterService.delete(id);
    }
}
