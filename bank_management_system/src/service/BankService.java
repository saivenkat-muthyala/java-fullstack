package bank_management_system.src.service;

import bank_management_system.src.expection.DuplicateCustomerException;
import bank_management_system.src.model.*;
import bank_management_system.src.expection.*;;

public class BankService {

    private Bank bank;

    public BankService(Bank bank) {
        this.bank = bank;
    }

    public void addCustomer(
            int customerId,
            String name,
            String mobileNumber,
            String email)
            throws DuplicateCustomerException {

        Customer customer =
            new Customer(
                customerId,
                name,
                mobileNumber,
                email
            );

        bank.addCustomer(customer);
    }

    public Account createSavingsAccount(
            int customerId)
            throws CustomerNotFoundException {

        return bank.createSavingsAccount(customerId);
    }

    public Account createCurrentAccount(
            int customerId)
            throws CustomerNotFoundException {

        return bank.createCurrentAccount(customerId);
    }

    public void deposit(
            int accountNumber,
            double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   AccountClosedException {

        bank.depositMoney(
            accountNumber,
            amount
        );
    }

    public void withdraw(
            int accountNumber,
            double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException,
                   AccountClosedException {

        bank.withdrawMoney(
            accountNumber,
            amount
        );
    }

    public void transfer(
            int fromAccountNumber,
            int toAccountNumber,
            double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException,
                   AccountClosedException {

        bank.transferMoney(
            fromAccountNumber,
            toAccountNumber,
            amount
        );
    }

    public Account getAccount(
            int accountNumber)
            throws AccountNotFoundException {

        return bank.findAccount(accountNumber);
    }

    public void showTransactionHistory(
            int accountNumber)
            throws AccountNotFoundException {

        Account account =
            bank.findAccount(accountNumber);

        account.printTransactionHistory();
    }

    public void closeAccount(
            int accountNumber)
            throws AccountNotFoundException,
                   AccountClosedException,
                   AccountHasBalanceException {

        bank.closeAccount(accountNumber);
    }

    public void listCustomers() {
        bank.listCustomers();
    }

    public void listAccounts() {
        bank.listAccounts();
    }
}