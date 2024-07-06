package ru.myproj.bankcreditsystem.model;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String passportSeriesNumber;
    private LocalDate dateOfBirth;
    @Transient
    private int age;
    private String registrationAddress;
    private String residentialAddress;
    @Column(unique = true)
    private String phoneNumber;
    private String education; // Образование
    private String maritalStatus; // семейное положение
    private String creditHistory;
    private String currentCredits; //   текущие кредиты
    private String assets; //активы (имущество)
    private double salaryLevel; // уровень зарплаты
    private int yearsAtCurrentJob; // стаж на текущем месте работы

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {

        return "Id: " + id + "\n" +
                "Full Name: " + (fullName != null ? fullName : "данные не заполнены") + "\n" +
                "Passport Series Number: " + (passportSeriesNumber != null ? passportSeriesNumber : "данные не заполнены") + "\n" +
                "Date of Birth: " + (dateOfBirth != null ? dateOfBirth : "данные не заполнены") + "\n" +
                "Age: " + (age != 0 ? age : "данные не заполнены") + "\n" +
                "Registration Address: " + (registrationAddress != null ? registrationAddress : "данные не заполнены") + "\n" +
                "Residential Address: " + (residentialAddress != null ? residentialAddress : "данные не заполнены") + "\n" +
                "Phone Number: " + (phoneNumber != null ? phoneNumber : "данные не заполнены") + "\n" +
                "Education: " + (education != null ? education : "данные не заполнены") + "\n" +
                "Marital Status: " + (maritalStatus != null ? maritalStatus : "данные не заполнены") + "\n" +
                "Credit History: " + (creditHistory != null ? creditHistory : "данные не заполнены") + "\n" +
                "Current Credits: " + (currentCredits != null ? currentCredits : "данные не заполнены") + "\n" +
                "Assets: " + (assets != null ? assets : "данные не заполнены") + "\n" +
                "Salary Level: " + (salaryLevel != 0 ? salaryLevel : "данные не заполнены") + "\n" +
                "Years at Current Job: " + (yearsAtCurrentJob != 0 ? yearsAtCurrentJob : "данные не заполнены") + "\n";
    }
}
