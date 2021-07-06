package com.db.client.domain;

public class Client {
    private final String clientName;
    private final Integer clientId;

    public Client(String clientName, Integer clientId) {
        this.clientName = clientName;
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
