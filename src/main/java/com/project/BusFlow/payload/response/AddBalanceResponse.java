package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddBalanceResponse {

    private UUID username;
    private Double balance;

    private String responseCode;
    private String responseBody;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public UUID getUsername() {
        return username;
    }

    public void setUsername(UUID username) {
        this.username = username;
    }
}
