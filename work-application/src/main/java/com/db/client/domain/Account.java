package com.db.client.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "clientId", "accountId", "accountAmount", "state" })
public class Account {
    private Integer clientId;
    private Integer accountId;
    private BigDecimal accountAmount;
    private Boolean state;

    public Account() {}

    public Account(Integer clientId, Integer accountId, BigDecimal accountAmount, Boolean state) {
        this.clientId = clientId;
        this.accountId = accountId;
        this.accountAmount = accountAmount;
        this.state = state;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public Boolean getState() {
        return state;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientId=" + clientId +
                ", accountId=" + accountId +
                ", accountAmount=" + accountAmount +
                ", state=" + state +
                '}';
    }
}
