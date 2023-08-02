package com.project.BusFlow.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Token_table")
public class Token {

    @Id
    @SequenceGenerator(name = "seqGen", initialValue = 10001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @Column(name = "Id")
    private long id;
    @Column(name = "Type")
    private String type;

    @Column(name = "Balance")
    private Double Balance;

    @Column(name = "Valid")
    private boolean valid;

    @Column(name = "Expire_Date")
    private LocalDate expireDate;

    @Column(name = "Create_Date")
    private LocalDate createDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Id")
    User userObj;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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