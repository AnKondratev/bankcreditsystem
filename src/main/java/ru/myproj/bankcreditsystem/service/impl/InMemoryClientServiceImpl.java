package ru.myproj.bankcreditsystem.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.myproj.bankcreditsystem.model.Client;
import ru.myproj.bankcreditsystem.repository.InMemoryClientDAO;
import ru.myproj.bankcreditsystem.service.ClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryClientServiceImpl implements ClientService {

    private final InMemoryClientDAO repository;

    @Override
    public List<Client> findAllClients() {
        return repository.findAllClients();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.saveClient(client);
    }

    @Override
    public Client findByPassport(String passportSeriesNumber) {
        return repository.findByPassport(passportSeriesNumber);
    }

    @Override
    public Client updateClient(Client client) {
        return repository.updateClient(client);
    }

    @Override
    public void deleteClient(String passportSeriesNumber) {
        repository.deleteClient(passportSeriesNumber);
    }

}

