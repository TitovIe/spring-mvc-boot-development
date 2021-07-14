package com.db.client.controller;

import com.db.client.domain.Account;
import com.db.client.domain.Client;
import com.db.client.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/operation")
public class OperationController {
    OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody Client client) {
        operationService.createClient(client);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccountForClient(@RequestBody Account account) {
        operationService.createAccountForClient(account);
    }

    @GetMapping("/accounts/{clientId}")
    public Collection<Account> findAllAccount(@PathVariable Integer clientId) {
        return operationService.findAllAccount(clientId);
    }

    @GetMapping("/state/{clientId}/{accountId}")
    public Boolean findAccountState(@PathVariable Integer clientId, @PathVariable Integer accountId) {
        return operationService.findAccountState(clientId, accountId);
    }
}
