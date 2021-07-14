package com.db.client.dao;

import com.db.client.domain.Account;
import com.db.client.domain.Client;

import java.math.BigDecimal;
import java.util.Collection;

public interface AccountRepository {
    Account create(Account account);
    Account create(Integer clientId, Integer accountId, BigDecimal accountAmount, Boolean state);
    Account findById(Integer accountId);
    Collection<Account> findAll();
    Collection<Account> findAllByClientId(Integer clientId);
}
