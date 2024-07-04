package ru.myproj.bankcreditsystem.service;

import ru.myproj.bankcreditsystem.model.Client;

import java.util.List;


public interface ClientService {
    List<Client> findAllClients();
    Client saveClient(Client client);
    Client findByPassport(String passportSeriesNumber);
    Client updateClient(Client client);
    void deleteClient(String passportSeriesNumber);

}
