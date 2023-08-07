package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

@Component
public class TotalPriceResponse {

    private String tokensRequired;
    private String totalCharges;

    private String responseCode;
    private String responseBody;

    public String getTokensRequired() {
        return tokensRequired;
    }

    public void setTokensRequired(String tokensRequired) {
        this.tokensRequired = tokensRequired;
    }

    public String getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
    }



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

    @Override
    public String toString() {
        return "TotalPriceResponse{" +
                "tokensRequired='" + tokensRequired + '\'' +
                ", totalCharges='" + totalCharges + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
