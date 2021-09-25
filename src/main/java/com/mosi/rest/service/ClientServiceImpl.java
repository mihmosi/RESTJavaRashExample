package com.mosi.rest.service;

import com.mosi.rest.model.Client;
import com.mosi.rest.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
        clientRepository.create(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.readAll();
    }

    @Override
    public Client read(Long id) {
        return clientRepository.read(id);
    }

    @Override
    public boolean update(Client client, Long id) {
        return clientRepository.update(client, id);
    }

    @Override
    public boolean delete(Long id) {
        return clientRepository.delete(id);
    }
}
