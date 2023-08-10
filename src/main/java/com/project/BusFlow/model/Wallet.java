package com.project.BusFlow.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Wallet_table")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_id_seq1")
    @SequenceGenerator(name = "school_id_seq1", sequenceName = "school_id_seq1",  allocationSize=1)
    @Column(name = "Id")
    private long id;

    @Column(name = "Tokens")
    private Integer tokens;

    @Column(name = "Balance")
    private Double balance;

    @OneToMany(cascade = CascadeType.ALL)
    List<Token> tokenList;

    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }

    @OneToOne(cascade = CascadeType.ALL)
    User userObj;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
