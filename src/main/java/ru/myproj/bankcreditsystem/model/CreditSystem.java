package ru.myproj.bankcreditsystem.model;

import org.springframework.stereotype.Component;

@Component
public class CreditSystem {
    TBank tBank;

    public String checkGetCredit(Client client, int sumCredit) {
        boolean checkSalary = tBank.getMinSalaryLevel(client, sumCredit);
        boolean checkYearsOld = tBank.getMinClientYearsOld() < client.getAge();
        boolean checkMinYearsAtCurrentJob = tBank.getMinYearsAtCurrentJob() < client.getYearsAtCurrentJob();
        boolean checkCreditHistory = tBank.isRequireCreditHistory().equals(client.getCreditHistory());
        return checkSalary
                && checkYearsOld
                && checkMinYearsAtCurrentJob
                && checkCreditHistory
                ? "Credit approved!" : "Credit not approved!";
    }
}
