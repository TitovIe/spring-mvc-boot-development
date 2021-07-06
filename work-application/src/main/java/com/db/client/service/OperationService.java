package com.db.client.service;

import com.db.client.dao.AccountRepository;
import com.db.client.dao.ClientRepository;
import com.db.client.domain.Account;
import com.db.client.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class OperationService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final Map<Client, Set<Account>> clientAccountMap;

    @Autowired
    public OperationService(@Value("${initial.capacity.account.map}") int initialCapacity, AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.clientAccountMap = new HashMap<>(initialCapacity);
        log.debug("Map of clientAccount with capacity {} was created", initialCapacity);
    }

    public void createAccountForClient(Integer clientId, Account account) {
        Client client = clientRepository.findById(clientId);
        if(client == null) {
            log.warn("The client with clientId {} doesn't exist", clientId);
        } else {
            clientAccountMap.get(client).add(account);
            accountRepository.create(account);
            log.debug("Account was created: {}", account);
        }
    }

    public void findAccountState(Integer clientId, Integer accountId) {
        if(clientRepository.findById(clientId) == null) {
            log.warn("The client with clientId {} doesn't exist", clientId);
        } else if(accountRepository.findById(accountId) == null) {
            log.warn("The account with accountId {} doesn't exist", accountId);
        }
        else {
            Boolean state = accountRepository.findById(accountId).getState();
            log.debug("State of accountId {} is {}", accountId, state);
            //clientAccountMap.get(client).stream().filter(account -> account.getAccountId().equals(accountId)).findFirst().get().getState();
        }
    }

    public void findAllAccount(Integer clientId) {
        Client client = clientRepository.findById(clientId);
        if (client == null) {
            log.warn("The client with clientId {} doesn't exist", clientId);
        } else {
            Set<Account> accounts = clientAccountMap.get(client);
            log.debug("Accounts of clientId {} are {}", clientId, accounts);
        }
    }

    public void createClient(Integer clientId, String clientName) {
        clientAccountMap.put(clientRepository.create(clientId, clientName), new HashSet<>());
        log.debug("Client with clientId {} and clientName {} was created", clientId, clientName);
    }
}
