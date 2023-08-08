package com.project.BusFlow.payload.request;

import java.util.UUID;

public class DeleteUserRequest {

    private UUID username;

    public UUID getUsername() {
        return username;
    }

    public void setUsername(UUID username) {
        this.username = username;
    }
}
