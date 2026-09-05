package bank_management_system.src.model;

import bank_management_system.src.expection.InsufficientBalanceException;
import bank_management_system.src.expection.InvalidAmountException;

public class SavingsAccount extends Account {
    private final double minimumBalance=500;

    public SavingsAccount(int accountNumber, Customer customer){
        super(accountNumber,customer);
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

        if (balance - amount < minimumBalance) {

            throw new InsufficientBalanceException(
                "Withdrawal failed. Minimum balance must be ₹500."
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
