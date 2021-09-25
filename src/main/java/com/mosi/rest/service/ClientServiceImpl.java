package com.mosi.rest.service;

import com.mosi.rest.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Override
    public void client(Client client) {

    }

    @Override
    public List<Client> readAll() {
        return null;
    }

    @Override
    public Client read(Long id) {
        return null;
    }

    @Override
    public boolean update(Client client, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
