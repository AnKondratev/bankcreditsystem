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
        System.out.println("""
                Menu:
                1. Add client
                2. View all clients
                3. Find client
                4. Update client
                5. Delete client
                0. Exit""");

    }

    private void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            displayMenu();
            System.out.print("Choose an action: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.println("Selected: Add client");
                    actions.saveClient(newClient.getNewClient(scanner));
                }

                case 2 -> {
                    try {
                        System.out.println("Selected: View all clients");
                        System.out.println(actions.findAllClients().toString());
                    } catch (Exception e) {
                        handleException(e);
                        scanner.nextLine();
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Selected: Find client by passport number");
                        System.out.println("Enter passport number: ");
                        scanner.nextLine();
                        System.out.println(actions.findByPassport(scanner.nextLine()));
                    } catch (Exception e) {
                        handleException(e);
                        scanner.nextLine();
                    }
                }

                case 4 -> {
                    try {
                        System.out.println("Selected: Update client");
                        System.out.println("Enter passport number: ");
                        scanner.nextLine();
                        actions.updateClient(actions.saveClient(newClient.getNewClient(scanner)));
                    } catch (Exception e) {
                        handleException(e);
                        scanner.nextLine();
                    }
                }

                case 5 -> {
                    try {
                        System.out.println("Selected: Delete client by passport number");
                        System.out.println("Enter passport number: ");
                        scanner.nextLine();
                        actions.deleteClient(scanner.nextLine());
                    } catch (Exception e) {
                        handleException(e);
                        System.out.println("Please enter the correct format!");
                        actions.deleteClient(scanner.nextLine());
                    }
                }

                case 0 -> {
                    System.out.println("Exit");
                    System.exit(0);
                }


            }
        }
    }

    @ExceptionHandler
    private void handleException(Exception e) {
        System.out.println("Please enter the correct format!");
    }

    public void getStartMenu() {
        startMenu();
    }
}
