package com.fatec.sp.gov.br.gta.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.gta.controller.View;

@Entity
@Table(name = "bkc_bank_character")
public class BankCharacter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bkc_id")
    private Long id;

    @Column(name = "bkc_balance")
    @JsonView(View.CharacterMain.class)
    private Long balance;

    @OneToOne
	@JoinColumn(name = "bkc_character_id", referencedColumnName = "cha_id")
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
