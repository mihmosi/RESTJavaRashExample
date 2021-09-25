package com.mosi.rest.repository;

import com.mosi.rest.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    // хранилище клиентов
    private static final Map<Long, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    // переменная для генерации ID клиента
    private static final AtomicLong CLIENT_ID_HOLDER = new AtomicLong();


    @Override
    public void create(Client client) {
        final Long clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(Long id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Client client, Long id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
