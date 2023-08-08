package com.project.BusFlow.payload.response;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserResponse {

    private String name;
    private String responseCode;
    private String responseBody;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
