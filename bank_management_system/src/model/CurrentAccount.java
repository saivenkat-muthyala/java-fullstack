package bank_management_system.src.model;

import bank_management_system.src.expection.InsufficientBalanceException;
import bank_management_system.src.expection.InvalidAmountException;

public class CurrentAccount extends Account {
    
    public final double overdraftLimit = 5000;

    public CurrentAccount(int accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public boolean withdraw(double amount)
            throws InvalidAmountException,
                InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (balance - amount < -overdraftLimit) {

            throw new InsufficientBalanceException(
                "Overdraft limit exceeded."
            );
        }

        balance -= amount;

        recordTransactions(
            "WITHDRAW",
            amount
        );

        return true;
    }
}
