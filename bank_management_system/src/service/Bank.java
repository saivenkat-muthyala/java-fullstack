package bank_management_system.src.service;
import java.util.*;
import bank_management_system.src.model.*;
import bank_management_system.src.expection.*;

public class Bank {

    private Map<Integer, Customer> customers;
    private Map<Integer, Account> accounts;

    private int nextAccountNumber = 100001;

    public Bank() {

        customers = new HashMap<>();
        accounts = new HashMap<>();
    }

    // -------------------------
    // Customer Management
    // -------------------------

    public void addCustomer(Customer customer)
            throws DuplicateCustomerException {

        int customerId = customer.getCustomerId();

        if (customers.containsKey(customerId)) {

            throw new DuplicateCustomerException(
                "Customer ID " + customerId +
                " already exists."
            );
        }

        customers.put(customerId, customer);

        System.out.println(
            "Customer added successfully."
        );
    }

    public Customer findCustomer(int customerId)
            throws CustomerNotFoundException {

        Customer customer =
            customers.get(customerId);

        if (customer == null) {

            throw new CustomerNotFoundException(
                "Customer " + customerId +
                " not found."
            );
        }

        return customer;
    }

    // -------------------------
    // Account Management
    // -------------------------

    private int generateAccountNumber() {

        return nextAccountNumber++;
    }

    public Account createSavingsAccount(
            int customerId)
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

        accounts.put(
            accountNumber,
            account
        );

        System.out.println(
            "Savings account created successfully."
        );

        System.out.println(
            "Account Number: " + accountNumber
        );

        return account;
    }

    public Account createCurrentAccount(
            int customerId)
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

        accounts.put(
            accountNumber,
            account
        );

        System.out.println(
            "Current account created successfully."
        );

        System.out.println(
            "Account Number: " + accountNumber
        );

        return account;
    }

    public Account findAccount(int accountNumber)
            throws AccountNotFoundException {

        Account account =
            accounts.get(accountNumber);

        if (account == null) {

            throw new AccountNotFoundException(
                "Account " + accountNumber +
                " not found."
            );
        }

        return account;
    }

    // -------------------------
    // Banking Operations
    // -------------------------

    public void depositMoney(
            int accountNumber,
            double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   AccountClosedException {

        Account account =
            findAccount(accountNumber);

        if (!account.isActive()) {

            throw new AccountClosedException(
                "Account " + accountNumber +
                " is closed."
            );
        }

        account.deposit(amount);
    }

    public void withdrawMoney(
            int accountNumber,
            double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException,
                   AccountClosedException {

        Account account =
            findAccount(accountNumber);

        if (!account.isActive()) {

            throw new AccountClosedException(
                "Account " + accountNumber +
                " is closed."
            );
        }

        account.withdraw(amount);
    }

    public void transferMoney(
            int fromAccountNumber,
            int toAccountNumber,
            double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException,
                   AccountClosedException {

        if (fromAccountNumber == toAccountNumber) {

            throw new InvalidAmountException(
                "Source and destination accounts " +
                "cannot be the same."
            );
        }

        Account fromAccount =
            findAccount(fromAccountNumber);

        Account toAccount =
            findAccount(toAccountNumber);

        if (!fromAccount.isActive()) {

            throw new AccountClosedException(
                "Source account " +
                fromAccountNumber +
                " is closed."
            );
        }

        if (!toAccount.isActive()) {

            throw new AccountClosedException(
                "Destination account " +
                toAccountNumber +
                " is closed."
            );
        }

        fromAccount.withdraw(amount);

        toAccount.deposit(amount);
    }

    // -------------------------
    // Account Closing
    // -------------------------

    public void closeAccount(int accountNumber)
            throws AccountNotFoundException,
                   AccountClosedException,
                   AccountHasBalanceException {

        Account account =
            findAccount(accountNumber);

        if (!account.isActive()) {

            throw new AccountClosedException(
                "Account " + accountNumber +
                " is already closed."
            );
        }

        if (account.getBalance() != 0) {

            throw new AccountHasBalanceException(
                "Account cannot be closed. " +
                "Remaining balance: ₹" +
                account.getBalance()
            );
        }

        account.closeAccount();

        System.out.println(
            "Account " + accountNumber +
            " closed successfully."
        );
    }

    // -------------------------
    // Display Methods
    // -------------------------

    public void listCustomers() {

        System.out.println("\n==============================");
        System.out.println("         CUSTOMERS");
        System.out.println("==============================");

        for (Customer customer : customers.values()) {

            System.out.println(
                "ID      : " +
                customer.getCustomerId()
            );

            System.out.println(
                "Name    : " +
                customer.getName()
            );

            System.out.println(
                "Mobile  : " +
                customer.getMobileNumber()
            );

            System.out.println(
                "Email   : " +
                customer.getEmail()
            );

            System.out.println("------------------------------");
        }
    }

    public void listAccounts() {

        System.out.println("\n==============================");
        System.out.println("         ACCOUNTS");
        System.out.println("==============================");

        for (Account account : accounts.values()) {

            System.out.println(
                "Account Number : " +
                account.getAccountNumber()
            );

            System.out.println(
                "Customer       : " +
                account.getCustomer().getName()
            );

            System.out.println(
                "Balance        : ₹" +
                account.getBalance()
            );

            System.out.println(
                "Status         : " +
                account.getStatus()
            );

            System.out.println("------------------------------");
        }
    }

    
}