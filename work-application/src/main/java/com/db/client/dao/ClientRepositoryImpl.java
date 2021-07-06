package com.db.client.dao;

import com.db.client.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class ClientRepositoryImpl implements ClientRepository {
    Map<Integer, Client> clientMap;

    public ClientRepositoryImpl(@Value("${initial.capacity.account.map}") int initialCapacity) {
        this.clientMap = new HashMap<>(initialCapacity);
        log.debug("Map of client with capacity {} was created", initialCapacity);
    }

    @Override
    public Client create(Client client) {
        clientMap.put(client.getClientId(), client);
        return client;
    }

    @Override
    public Client create(Integer clientId, String clientName) {
        Client client = new Client(clientName, clientId);
        clientMap.put(clientId, client);
        return client;
    }

    @Override
    public Client findById(Integer clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public Collection<Client> findAll() {
        return clientMap.values();
    }
}
