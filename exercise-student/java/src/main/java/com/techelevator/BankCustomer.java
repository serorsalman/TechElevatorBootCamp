package com.techelevator;
import java.util.ArrayList;
import java.util.List;
public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Accountable[] getAccounts() {
        Accountable[] testArray = new Accountable[accounts.size()];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = accounts.get(i);
        }
        return testArray;
    }
    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }
    public boolean isVip() {
        int runningTotal = 0;
        for (Accountable account : accounts) {
            runningTotal += account.getBalance();
        }
        if (runningTotal >= 25000) {
            return true;
        } else {
            return false;
        }
    }
}