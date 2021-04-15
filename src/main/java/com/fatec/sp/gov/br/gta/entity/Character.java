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
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "cha_character")
public class Character {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cha_id")
    private Long id;

    @Column(name = "cha_name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "grc_group_character",
		joinColumns = { @JoinColumn(name = "grc_character_id") },
		inverseJoinColumns = { @JoinColumn(name = "grc_group_id") })
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
