package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

@Component
public class TotalPriceServiceResponse {

    private String tokens;
    private String totalCharge;

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }

    public String getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(String totalCharge) {
        this.totalCharge = totalCharge;
    }
}
