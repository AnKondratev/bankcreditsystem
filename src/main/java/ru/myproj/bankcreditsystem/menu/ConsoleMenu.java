package ru.myproj.bankcreditsystem.menu;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.myproj.bankcreditsystem.service.impl.ClientServiceImpl;

import java.util.Scanner;

@Component
@AllArgsConstructor
public class ConsoleMenu {

    private final ClientServiceImpl actions;
    private ConsoleClientAddition newClient;

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add client");
        System.out.println("2. View all clients");
        System.out.println("3. Find client");
        System.out.println("4. Update client");
        System.out.println("5. Delete client");
        System.out.println("0. Exit");
    }

    private void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            displayMenu();
            System.out.print("Choose an action: ");
            try {
                choice = scanner.nextInt();

                switch (choice) {

                    case 1 -> {
                        System.out.println("Selected: Add client");
                        actions.saveClient(newClient.getNewClient());
                    }

                    case 2 -> {
                        System.out.println("Selected: View all clients");
                        System.out.println("For proper viewing of all clients, use the database table!");
                        System.out.println("If you want to display client data in the console, press 1");
                        int secondChoice = scanner.nextInt();
                        if (secondChoice == 1) {
                            System.out.println(actions.findAllClients().toString());
                        }
                    }

                    case 3 -> {
                        System.out.println("Selected: Find client by passport number");
                        System.out.println("Enter passport number: ");
                        scanner.nextLine();
                        System.out.println(actions.findByPassport(scanner.nextLine()));
                    }

                    case 4 -> {
                        System.out.println("Selected: Update client");
                        System.out.println("Enter passport number: ");
                        scanner.nextLine();
                        actions.updateClient(actions.saveClient(newClient.getNewClient()));
                    }

                    case 5 -> {
                        System.out.println("Selected: Delete client by passport number");
                        System.out.println("Enter passport number: ");
                        scanner.nextLine();
                        actions.deleteClient(scanner.nextLine());
                    }

                    case 0 -> {
                        System.out.println("Exit");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice, please try again.");

                }
            } catch (Exception e) {
                handleException(e);
                scanner.nextLine();
            }
        }
    }

    @ExceptionHandler
    private void handleException(Exception e) {
        System.out.println("Invalid input, try entering the menu item number.");
    }

    public void getStartMenu() {
        startMenu();
    }
}
