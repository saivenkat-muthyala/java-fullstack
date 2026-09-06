package bank_management_system.src.model;

import java.util.*;

import bank_management_system.src.expection.*;

public abstract class Account {

    private int accountNumber;
    private Customer customer;

    protected double balance;

    private AccountStatus status;

    private List<Transaction> transactions;

    private int nextTransactionId = 1;

    public Account(int accountNumber, Customer customer) {

        this.accountNumber = accountNumber;
        this.customer = customer;

        this.balance = 0;

        this.status = AccountStatus.ACTIVE;

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

    public AccountStatus getStatus() {
        return status;
    }

    public boolean isActive() {
        return status == AccountStatus.ACTIVE;
    }

    public void closeAccount() {
        status = AccountStatus.CLOSED;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        recordTransaction(
            "DEPOSIT",
            amount
        );
    }

    protected void recordTransaction(
            String type,
            double amount) {

        Transaction transaction =
            new Transaction(
                nextTransactionId++,
                type,
                amount,
                balance
            );

        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void printTransactionHistory() {

    System.out.println("\n=========================================");
    System.out.println("         TRANSACTION HISTORY");
    System.out.println("=========================================");

    System.out.printf(
        "%-5s %-12s %-12s %-12s%n",
        "ID",
        "TYPE",
        "AMOUNT",
        "BALANCE"
    );

    System.out.println("-----------------------------------------");

    for (Transaction transaction : transactions) {

        System.out.printf(
            "%-5d %-12s ₹%-11.2f ₹%-11.2f%n",
            transaction.getTransactionId(),
            transaction.getType(),
            transaction.getAmount(),
            transaction.getBalanceAfterTransaction()
        );
    }

    System.out.println("=========================================");
}

    public abstract boolean withdraw(double amount)
            throws InvalidAmountException,
                   bank_management_system.src.expection.InsufficientBalanceException;
}