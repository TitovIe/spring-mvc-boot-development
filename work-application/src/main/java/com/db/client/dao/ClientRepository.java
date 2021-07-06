package com.db.client.dao;

import com.db.client.domain.Client;
import java.util.Collection;

public interface ClientRepository {
    Client create(Client client);
    Client create(Integer clientId, String clientName);
    Client findById(Integer clientId);
    Collection<Client> findAll();
}
