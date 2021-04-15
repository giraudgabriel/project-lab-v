package com.fatec.sp.gov.br.gta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class Character {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_character",
		joinColumns = { @JoinColumn(name = "characterId") },
		inverseJoinColumns = { @JoinColumn(name = "groupId") })
	private Set<Group> groups;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "character")
	private Set<BankCharacter> banks;

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

     public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
    
     public Set<BankCharacter> getBanks() {
        return banks;
    }

    public void setBanks(Set<BankCharacter> banks) {
        this.banks = banks;
    }
}
