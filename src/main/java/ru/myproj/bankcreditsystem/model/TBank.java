package ru.myproj.bankcreditsystem.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TBank implements Bank {

    @Override
    public String getName() {
        return "T-Bank";
    }

    @Override
    public boolean getMinSalaryLevel(Client client, int sumCredit) {
        double minSalary = 0.3 * sumCredit;
        return client.getSalaryLevel() >= minSalary;
    }

    @Override
    public int getMinClientYearsOld() {
        return 21;
    }

    @Override
    public int getMinYearsAtCurrentJob() {
        return 3;
    }

    @Override
    public String isRequireCreditHistory() {
        return "Good";
    }

    @Override
    public boolean isRequireAssets() {
        return true;
    }
}
