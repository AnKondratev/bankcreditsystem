package ru.myproj.bankcreditsystem.repository;

import org.springframework.stereotype.Repository;
import ru.myproj.bankcreditsystem.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryClientDAO {
    private final List<Client> CLIENTS = new ArrayList<>();

    public List<Client> findAllClients() {
        return CLIENTS;
    }

    public Client saveClient(Client client) {
        CLIENTS.add(client);
        return client;
    }

    public Client findByPassport(String passportSeriesNumber) {
        return CLIENTS.stream()
                .filter(client -> client.getPassportSeriesNumber()
                        .equals(passportSeriesNumber)).findFirst().orElse(null);
    }

    public Client updateClient(Client client) {
        Client result = null;
        var clientIndex = IntStream.range(0, CLIENTS.size())
                .filter(index -> CLIENTS.get(index)
                        .getPassportSeriesNumber().equals(client.getPassportSeriesNumber()))
                .findFirst().orElse(-1);
        if (clientIndex > -1 && clientIndex < CLIENTS.size()) {
            CLIENTS.set(clientIndex, client);
            result = client;
        }
        return result;
    }

    public void deleteClient(String passportSeriesNumber) {
        var client = findByPassport(passportSeriesNumber);
        if (client != null) {
            CLIENTS.remove(client);
        }
    }
}
