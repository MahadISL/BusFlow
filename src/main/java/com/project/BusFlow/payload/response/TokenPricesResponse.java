package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

@Component
public class TokenPricesResponse {


    private String oneToken;
    private String oneMonth;
    private String threeMonth;
    private String sixMonth;
    private String oneYear;
    private String responseCode;
    private String responseBody;

    public String getOneToken() {
        return oneToken;
    }

    public void setOneToken(String oneToken) {
        this.oneToken = oneToken;
    }

    public String getOneMonth() {
        return oneMonth;
    }

    public void setOneMonth(String oneMonth) {
        this.oneMonth = oneMonth;
    }

    public String getThreeMonth() {
        return threeMonth;
    }

    public void setThreeMonth(String threeMonth) {
        this.threeMonth = threeMonth;
    }

    public String getSixMonth() {
        return sixMonth;
    }

    public void setSixMonth(String sixMonth) {
        this.sixMonth = sixMonth;
    }

    public String getOneYear() {
        return oneYear;
    }

    public void setOneYear(String oneYear) {
        this.oneYear = oneYear;
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
        return "TokenPricesResponse{" +
                "oneToken='" + oneToken + '\'' +
                ", oneMonth='" + oneMonth + '\'' +
                ", threeMonth='" + threeMonth + '\'' +
                ", sixMonth='" + sixMonth + '\'' +
                ", oneYear='" + oneYear + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
