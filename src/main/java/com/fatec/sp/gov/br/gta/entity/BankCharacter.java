package com.fatec.sp.gov.br.gta.entity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "bank_character")
public class BankCharacter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private Long balance;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "characterId")
	private Character character;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }


    public Character getCharacter(){
        return character;
    }
    public void setCharacter(Character character){
        this.character = character;
    }
    
}
