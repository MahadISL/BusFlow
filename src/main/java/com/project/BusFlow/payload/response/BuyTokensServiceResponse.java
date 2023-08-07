package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BuyTokensServiceResponse {

    private Integer tokens;
    private Double cost;
    private LocalDate expiry;

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }
}
