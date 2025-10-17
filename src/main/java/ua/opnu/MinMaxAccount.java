package ua.opnu;

import ua.opnu.java.inheritance.account.*;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int balance = getBalance();
        minBalance = balance;
        maxBalance = balance;
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }

    @Override
    public void credit(Credit amount) {
        super.credit(amount);
        updateMinMax();
    }

    @Override
    public void debit(Debit amount) {
        super.debit(amount);
        updateMinMax();
    }

    private void updateMinMax() {
        int balance = getBalance();
        if (balance < minBalance) minBalance = balance;
        if (balance > maxBalance) maxBalance = balance;
    }
}
