package ru.myproj.bankcreditsystem.menu;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.myproj.bankcreditsystem.model.Client;
import ru.myproj.bankcreditsystem.service.impl.ClientServiceImpl;

@Component
@AllArgsConstructor
public class ConsoleClientAddition {

    private final ClientServiceImpl actions;

    private Client newClient(Scanner scanner) {
        Client client = new Client();
        System.out.println("Enter passport series and number:");
        scanner.nextLine();
        client.setPassportSeriesNumber(scanner.nextLine());

        if (actions.findByPassport(client.getPassportSeriesNumber()) != null) {
            System.out.println("Error! Passport number already exists. Please check input data.");
            newClient(scanner);
        }

        System.out.println("Enter client's full name:");
        client.setFullName(scanner.nextLine());

        System.out.println("Enter date of birth (dd.MM.yyyy):");
        while (true) {
            try {
                client.setDateOfBirth(LocalDate.parse(scanner.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                break;
            } catch (DateTimeParseException e) {
                handleException();
                System.out.println(e.getMessage() + "\n"
                        + "Please enter the date of birth in the correct format (dd.MM.yyyy):");
            }
        }

        int finish;
        do {
            System.out.println("""
                    Choose an action:
                    1. Continue data input
                    0. Finish data input and save new client""");


            finish = scanner.nextInt();
            scanner.nextLine();
            if (finish == 1) {

                System.out.println("Enter registration address:");
                client.setRegistrationAddress(scanner.nextLine());

                System.out.println("Enter residential address:");
                client.setResidentialAddress(scanner.nextLine());

                System.out.println("Enter phone number:");
                client.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter education level:");
                client.setEducation(scanner.nextLine());

                System.out.println("Enter marital status:");
                client.setMaritalStatus(scanner.nextLine());

                System.out.println("Enter credit history rating:");
                client.setCreditHistory(scanner.nextLine());

                System.out.println("Enter current credits information:");
                client.setCurrentCredits(scanner.nextLine());

                System.out.println("Enter assets information:");
                client.setAssets(scanner.nextLine());

                System.out.println("Enter salary level:");

                while (true) {
                    try {
                        client.setSalaryLevel(Integer.parseInt(scanner.nextLine()));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid integer value!");
                    }
                }

                System.out.println("Enter years at current job:");
                client.setYearsAtCurrentJob(scanner.nextInt());
                scanner.nextLine();
                break;
            }


        } while (finish != 0);

        System.out.println("Client creation completed.");
        return client;

    }

    public Client getNewClient(Scanner scanner) {
        return newClient(scanner);
    }

    @ExceptionHandler(DateTimeException.class)
    private void handleException() {
        System.out.println("Incorrect entry, observe the date entry format!");
    }
}