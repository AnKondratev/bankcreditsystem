package ru.myproj.bankcreditsystem.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.myproj.bankcreditsystem.model.Client;
import ru.myproj.bankcreditsystem.repository.ClientRepository;
import ru.myproj.bankcreditsystem.service.ClientService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;


    @Override
    public List<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client findByPassport(String passport) {
        return repository.findByPassportSeriesNumber(passport);
    }

    @Override
    public Client updateClient(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(String passport) {
        repository.deleteByPassportSeriesNumber(passport);
    }

}
