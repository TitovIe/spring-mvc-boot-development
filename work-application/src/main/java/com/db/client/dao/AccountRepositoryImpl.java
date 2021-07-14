package com.db.client.dao;

import com.db.client.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    Map<Integer, Account> accountMap;

    public AccountRepositoryImpl(@Value("${initial.capacity.account.map}") int initialCapacity) {
        this.accountMap = new HashMap<>(initialCapacity);
        log.debug("Map of account with capacity {} was created", initialCapacity);
    }
    @Override
    public Account create(Account account) {
        accountMap.put(account.getAccountId(), account);
        return account;
    }
    @Override
    public Account create(Integer clientId, Integer accountId, BigDecimal accountAmount, Boolean state) {
        Account account = new Account(clientId, accountId, accountAmount, state);
        accountMap.put(accountId, account);
        return account;
    }

    @Override
    public Account findById(Integer accountId) {
        return accountMap.get(accountId);
    }

    @Override
    public Collection<Account> findAll() {
        return accountMap.values();
    }

    @Override
    public Collection<Account> findAllByClientId(Integer clientId) {
        return accountMap.values().stream().filter(account -> account.getClientId().equals(clientId)).collect(Collectors.toSet());
    }
}
