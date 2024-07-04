package ru.myproj.bankcreditsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.myproj.bankcreditsystem.controller.ClientsController;


@SpringBootApplication
public class BankCredApplication {

    public static void main(String[] args) {
        //      SpringApplication.run(BankCredApplication.class, args);

        ApplicationContext context = SpringApplication.run(BankCredApplication.class, args);
        ClientsController clientsController = context.getBean(ClientsController.class);
        clientsController.start();
    }
}
