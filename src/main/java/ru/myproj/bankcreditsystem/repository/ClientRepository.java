package ru.myproj.bankcreditsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myproj.bankcreditsystem.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    void deleteByPassportSeriesNumber(String passport);
    Client findByPassportSeriesNumber(String passport);
}
