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
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id).append("\n");
        sb.append("Full Name: ").append(fullName != null ? fullName : "данные не заполнены").append("\n");
        sb.append("Passport Series Number: ").append(passportSeriesNumber != null ? passportSeriesNumber : "данные не заполнены").append("\n");
        sb.append("Date of Birth: ").append(dateOfBirth != null ? dateOfBirth : "данные не заполнены").append("\n");
        sb.append("Age: ").append(age != 0 ? age : "данные не заполнены").append("\n");
        sb.append("Registration Address: ").append(registrationAddress != null ? registrationAddress : "данные не заполнены").append("\n");
        sb.append("Residential Address: ").append(residentialAddress != null ? residentialAddress : "данные не заполнены").append("\n");
        sb.append("Phone Number: ").append(phoneNumber != null ? phoneNumber : "данные не заполнены").append("\n");
        sb.append("Education: ").append(education != null ? education : "данные не заполнены").append("\n");
        sb.append("Marital Status: ").append(maritalStatus != null ? maritalStatus : "данные не заполнены").append("\n");
        sb.append("Credit History: ").append(creditHistory != null ? creditHistory : "данные не заполнены").append("\n");
        sb.append("Current Credits: ").append(currentCredits != null ? currentCredits : "данные не заполнены").append("\n");
        sb.append("Assets: ").append(assets != null ? assets : "данные не заполнены").append("\n");
        sb.append("Salary Level: ").append(salaryLevel != 0 ? salaryLevel : "данные не заполнены").append("\n");
        sb.append("Years at Current Job: ").append(yearsAtCurrentJob != 0 ? yearsAtCurrentJob : "данные не заполнены").append("\n");

        return sb.toString();
    }
}
