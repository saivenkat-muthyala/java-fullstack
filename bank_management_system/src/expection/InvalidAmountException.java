package bank_management_system.src.expection;

public class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}