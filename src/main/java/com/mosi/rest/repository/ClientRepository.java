package com.mosi.rest.repository;

import com.mosi.rest.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {
    public void create(Client client);

    public List<Client> readAll();

    public Client read(Long id);

    public boolean update(Client client, Long id);

    public boolean delete(Long id);

}
