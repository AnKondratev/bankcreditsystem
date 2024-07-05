package ru.myproj.bankcreditsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.myproj.bankcreditsystem.menu.ConsoleMenu;
import ru.myproj.bankcreditsystem.model.Client;
import ru.myproj.bankcreditsystem.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credit")
@AllArgsConstructor
public class ClientsController {

    private final ConsoleMenu startMenu;
    private final ClientService clientService;

    @GetMapping("find_all_clients")
    public List<Client> findAllClients() {
        return clientService.findAllClients();
    }

    @PostMapping("save_client")
    public String saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return "Client " + client.getFullName() + " has been successfully saved";
    }

    @GetMapping("/{passport}")
    public Client findByPassport(@PathVariable String passport) { // Аннотация @PathVariable используется для связывания значений из URL с параметрами метода.
        return clientService.findByPassport(passport);
    }

    @PutMapping("update_client")
    public String updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return "Client data " + client.getFullName() + " successfully updated";
    }

    @DeleteMapping("delete_client/{passport}")
    public String deleteClient(@PathVariable String passport) {
        clientService.deleteClient(passport);
        return "Client " + findByPassport(passport).getFullName() + "  has been removed from the database";
    }

    public void start() {
        startMenu.getStartMenu();
    }
}

