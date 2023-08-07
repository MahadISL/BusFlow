package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

@Component
public class TokenPricesServiceResponse {

    private String oneToken;
    private String oneMonth;
    private String threeMonth;
    private String sixMonth;
    private String oneYear;

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

    public String getOneToken() {
        return oneToken;
    }

    public void setOneToken(String oneToken) {
        this.oneToken = oneToken;
    }

    @Override
    public String toString() {
        return "TokenPricesServiceResponse{" +
                "oneToken='" + oneToken + '\'' +
                ", oneMonth='" + oneMonth + '\'' +
                ", threeMonth='" + threeMonth + '\'' +
                ", sixMonth='" + sixMonth + '\'' +
                ", oneYear='" + oneYear + '\'' +
                '}';
    }
}
