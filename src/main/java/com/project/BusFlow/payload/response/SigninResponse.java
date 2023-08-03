package com.project.BusFlow.payload.response;

import org.springframework.stereotype.Component;

@Component
public class SigninResponse {

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
}
