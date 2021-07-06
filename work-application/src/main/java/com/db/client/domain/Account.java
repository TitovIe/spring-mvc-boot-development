package com.db.client.domain;

import java.math.BigDecimal;

public class Account {
    private final Integer accountId;
    private final BigDecimal accountAmount;
    private final Boolean state;

    public Account(Integer accountId, BigDecimal accountAmount, Boolean state) {
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

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountAmount=" + accountAmount +
                ", state=" + state +
                '}';
    }
}
