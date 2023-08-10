package com.project.BusFlow.model;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@Entity
@Table(name = "Token_table")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_id_seq")
    @SequenceGenerator(name = "school_id_seq", sequenceName = "school_id_seq",  allocationSize=1)
    @Column(name = "Id", unique = true, updatable=false)
    private long id;

    @Column(name = "Token_Count")
    private Integer tokenCount;

    @Column(name = "Balance")
    private Double Balance;

    @Column(name = "Valid")
    private boolean valid;

    @Column(name = "Expire_Date")
    private LocalDate expireDate;

    @Column(name = "Create_Date")
    private LocalDate createDate;

    @Column(unique = true, name = "Token_Code")
    private String tokeCode;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    User userObj;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Wallet_Id")
    Wallet walletObj;

    public Token(Integer tokenCount, Double balance, boolean valid, LocalDate expireDate, LocalDate createDate, User userObj) {
        this.tokenCount = tokenCount;
        this.Balance = balance;
        this.valid = valid;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.userObj = userObj;
    }

    public Token() {
    }

    public String getTokeCode() {
        return tokeCode;
    }

    public void setTokeCode(String tokeCode) {
        this.tokeCode = tokeCode;
    }

    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }

    public Integer getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(Integer tokenCount) {
        this.tokenCount = tokenCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}