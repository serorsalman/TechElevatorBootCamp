package com.techelevator;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(int balance) {
        super(balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if (super.getBalance() < amountToWithdraw) {// withdraw fail
            return getBalance();


    } else if (this.getBalance() - amountToWithdraw < 150) {
        amountToWithdraw += 2;
    }

        return super.withdraw(amountToWithdraw);
}
}


