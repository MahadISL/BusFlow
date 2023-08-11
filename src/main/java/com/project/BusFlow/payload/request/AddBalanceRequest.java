package com.project.BusFlow.payload.request;

import java.util.UUID;

public class AddBalanceRequest {

    private UUID username;
    private Double balance;
    private Integer tokens;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }

    public UUID getUsername() {
        return username;
    }

    public void setUsername(UUID username) {
        this.username = username;
    }
}
