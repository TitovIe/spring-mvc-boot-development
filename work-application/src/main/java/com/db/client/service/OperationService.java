package com.db.client.service;

import com.db.client.dao.AccountRepository;
import com.db.client.dao.ClientRepository;
import com.db.client.domain.Account;
import com.db.client.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class OperationService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public OperationService(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public void createAccountForClient(Account account) {
        Client client = clientRepository.findById(account.getClientId());
        if(client == null) {
            log.warn("The client with clientId {} doesn't exist", account.getClientId());
        } else {
            accountRepository.create(account);
            log.debug("Account was created: {}", account);
        }
    }

    public Boolean findAccountState(Integer clientId, Integer accountId) {
        Boolean state = false;
        if(clientRepository.findById(clientId) == null) {
            log.warn("The client with clientId {} doesn't exist", clientId);
        } else if(accountRepository.findById(accountId) == null) {
            log.warn("The account with accountId {} doesn't exist", accountId);
        }
        else {
            state = accountRepository.findById(accountId).getState();
            log.debug("State of accountId {} is {}", accountId, state);
            //clientAccountMap.get(client).stream().filter(account -> account.getAccountId().equals(accountId)).findFirst().get().getState();
        }
        return state;
    }

    public Collection<Account> findAllAccount(Integer clientId) {
        Client client = clientRepository.findById(clientId);
        Collection<Account> accounts;
        if (client == null) {
            accounts = new HashSet<>();
            log.warn("The client with clientId {} doesn't exist", clientId);
        } else {
            accounts = accountRepository.findAllByClientId(clientId);
            log.debug("Accounts of clientId {} are {}", clientId, accounts);
        }
        return accounts;
    }

    public void createClient(Client client) {
        clientRepository.create(client);
        log.debug("Client with clientId {} and clientName {} was created", client.getClientId(), client.getClientName());
    }
}
