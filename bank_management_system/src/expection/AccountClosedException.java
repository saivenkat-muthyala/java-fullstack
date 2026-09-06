package bank_management_system.src.expection;

public class AccountClosedException extends Exception {

    public AccountClosedException(String message) {
        super(message);
    }
}
