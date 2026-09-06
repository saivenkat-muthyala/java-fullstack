package bank_management_system.src.expection;

public class AccountHasBalanceException extends Exception {

    public AccountHasBalanceException(String message) {
        super(message);
    }
}
