package com.fatec.sp.gov.br.gta.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.gta.controller.View;

@Entity
@Table(name = "gro_group")
public class Group {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "gro_id")
    @JsonView(View.CharacterMain.class)
    private Long id;
   
    @JsonView(View.CharacterDto.class)
    @Column(name = "gro_code")
    private String code;

    @JsonView(View.CharacterMain.class)
    @Column(name = "gro_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    public Set<Character> characters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
    
}
