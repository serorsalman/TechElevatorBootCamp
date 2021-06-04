package com.techelevator;

public class CreditCardAccount implements Accountable{
    private String accountHolder;
    private String accountNumber;
    private int debt;
// constructor
    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;

    }
// getter
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
    // method
    public int pay(int amountToPay){
        debt = debt - amountToPay;
        return debt;
    }
    public int charge (int amountToCharge){
        debt = debt + amountToCharge;
        return debt;
    }

// implementing the interface

    @Override
    public int getBalance() {
        return (-debt);
    }
}
