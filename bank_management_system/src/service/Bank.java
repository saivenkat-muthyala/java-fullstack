package bank_management_system.src.service;
import java.util.*;
import bank_management_system.src.model.*;
import bank_management_system.src.expection.*;

public class Bank {

    private List<Customer> customers;
    private List<Account> accounts;

    private int nextAccountNumber = 100001;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    // -------------------------
    // Customer Operations
    // -------------------------

    public void addCustomer(Customer customer) {

        customers.add(customer);

        System.out.println(
            "Customer added successfully."
        );
    }

    public Customer findCustomer(int customerId)
            throws CustomerNotFoundException {

        for (Customer customer : customers) {

            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        throw new CustomerNotFoundException(
            "Customer " + customerId + " not found."
        );
    }

    // -------------------------
    // Account Operations
    // -------------------------

    private int generateAccountNumber() {

        return nextAccountNumber++;
    }

    public Account createSavingsAccount(int customerId)
            throws CustomerNotFoundException {

        Customer customer =
            findCustomer(customerId);

        int accountNumber =
            generateAccountNumber();

        Account account =
            new SavingsAccount(
                accountNumber,
                customer
            );

        accounts.add(account);

        return account;
    }

    public Account createCurrentAccount(int customerId)
            throws CustomerNotFoundException {

        Customer customer =
            findCustomer(customerId);

        int accountNumber =
            generateAccountNumber();

        Account account =
            new CurrentAccount(
                accountNumber,
                customer
            );

        accounts.add(account);

        return account;
    }
    public Account findAccount(int accountNumber)
            throws AccountNotFoundException {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        throw new AccountNotFoundException(
            "Account " + accountNumber + " not found."
        );
    }

    // -------------------------
    // Banking Operations
    // -------------------------

    public void depositMoney(
            int accountNumber,
            double amount)
            throws AccountNotFoundException,
                InvalidAmountException {

        Account account =
            findAccount(accountNumber);

        account.deposit(amount);
    }

    public void withdrawMoney(
            int accountNumber,
            double amount)
            throws AccountNotFoundException,
                InvalidAmountException,
                InsufficientBalanceException {

        Account account =
            findAccount(accountNumber);

        account.withdraw(amount);
    }

    public void checkBalance(int accountNumber) throws AccountNotFoundException {

        Account account =
            findAccount(accountNumber);

        if (account == null) {
            System.out.println(
                "Account not found."
            );
            return;
        }

        System.out.println(
            "Account Number: "
            + account.getAccountNumber()
        );

        System.out.println(
            "Account Holder: "
            + account.getCustomer().getName()
        );

        System.out.println(
            "Balance: ₹"
            + account.getBalance()
        );
    }

    public void transferMoney(
            int fromAccountNumber,
            int toAccountNumber,
            double amount)
            throws AccountNotFoundException,
                InvalidAmountException,
                InsufficientBalanceException {

        Account fromAccount =
            findAccount(fromAccountNumber);

        Account toAccount =
            findAccount(toAccountNumber);

        if (fromAccountNumber == toAccountNumber) {

            throw new InvalidAmountException(
                "Source and destination accounts cannot be the same."
            );
        }

        fromAccount.withdraw(amount);

        toAccount.deposit(amount);
    }
}