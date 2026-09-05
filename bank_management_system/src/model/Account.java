package bank_management_system.src.model;

import java.util.ArrayList;
import java.util.List;

import bank_management_system.src.expection.InsufficientBalanceException;
import bank_management_system.src.expection.InvalidAmountException;

public abstract class Account {
    
    private int accountNumber;
    private Customer customer;
    protected double balance;
    private List<Transaction> transactions;
    private int nextTransactionId = 1;

    public Account (int accountNumber, Customer customer){
        this.accountNumber=accountNumber;
        this.customer=customer;
        this.balance=0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        recordTransactions(
            "DEPOSIT",
            amount
        );
    }

    public abstract boolean withdraw(double amount)
        throws InvalidAmountException,
               InsufficientBalanceException;

    protected void recordTransactions( String type, double amount){

        Transaction transaction = new Transaction(nextTransactionId++, type, amount, balance);

        transactions.add(transaction);

    }


    public void printTransactionHistory() {

        System.out.println(
            "\n========================================="
        );

        System.out.println(
            "         TRANSACTION HISTORY"
        );

        System.out.println(
            "========================================="
        );

        System.out.printf(
            "%-5s %-12s %-12s %-12s%n",
            "ID",
            "TYPE",
            "AMOUNT",
            "BALANCE"
        );

        System.out.println(
            "-----------------------------------------"
        );

        for (Transaction transaction : transactions) {

            System.out.printf(
                "%-5d %-12s ₹%-11.2f ₹%-11.2f%n",
                transaction.getTransactionId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getBalanceAfterTransaction()
            );
        }

        System.out.println(
            "========================================="
    );
}
}
