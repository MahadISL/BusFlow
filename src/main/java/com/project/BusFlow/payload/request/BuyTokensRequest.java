package com.project.BusFlow.payload.request;

import java.util.UUID;

public class BuyTokensRequest {

    private int code;
    private UUID userId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
