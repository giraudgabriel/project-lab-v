package com.fatec.sp.gov.br.gta.entity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.gta.controller.View;

@Entity
@Table(name = "cha_character")
public class Character {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cha_id")
    @JsonView(View.CharacterMain.class)
    private Long id;

    @JsonView(View.CharacterDto.class)
    @Column(name = "cha_name", nullable = false)
    private String name;

    @JsonView(View.CharacterMain.class)
    @Column(name = "cha_password", nullable = false)
    private String password;

    @JsonView(View.CharacterDto.class)
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "grc_group_character",
		joinColumns = { @JoinColumn(name = "grc_character_id") },
		inverseJoinColumns = { @JoinColumn(name = "grc_group_id") })
	private Set<Group> groups;

    @JsonView(View.CharacterMain.class)
    @OneToOne(mappedBy = "character")
	private BankCharacter bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


     public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
    
     public BankCharacter getBank() {
        return bank;
    }

    public void setBank(BankCharacter bank) {
        this.bank = bank;
    }
}
