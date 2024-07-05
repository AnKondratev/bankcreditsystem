package ru.myproj.bankcreditsystem.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import ru.myproj.bankcreditsystem.model.Client;
import ru.myproj.bankcreditsystem.service.impl.ClientServiceImpl;

@Component
public class ConsoleClientAddition {

    private final ClientServiceImpl actions;

    public ConsoleClientAddition(ClientServiceImpl actions) {
        this.actions = actions;
    }

    private Client newClient() {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Enter passport series and number:");
        client.setPassportSeriesNumber(scanner.nextLine());
        if (actions.findByPassport(client.getPassportSeriesNumber()) != null) {
            System.out.println("Error! Passport number already exists. Please check input data.");
            return newClient();
        }

        System.out.println("Enter client's full name:");
        client.setFullName(scanner.nextLine());

        System.out.println("Enter date of birth (dd.MM.yyyy):");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);
        client.setDateOfBirth(dateOfBirth);
        int finish;
        do {
            System.out.println("Enter 1 to continue data input or 0 to finish data input:");
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
                client.setSalaryLevel(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Enter years at current job:");
                client.setYearsAtCurrentJob(scanner.nextInt());
                scanner.nextLine();
                break;
            }
        } while (finish != 0);

        System.out.println("Client creation completed.");
        return client;
    }

    public Client getNewClient() {
        return newClient();
    }
}