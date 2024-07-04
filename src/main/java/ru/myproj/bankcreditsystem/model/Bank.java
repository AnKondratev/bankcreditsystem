package ru.myproj.bankcreditsystem.model;


public interface Bank {

    String getName();

    boolean getMinSalaryLevel(Client client, int sumCredit);

    int getMinClientYearsOld();

    int getMinYearsAtCurrentJob();

    String isRequireCreditHistory();

    boolean isRequireAssets();

}
