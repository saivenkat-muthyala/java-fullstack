package bank_management_system.src.expection;

public class DuplicateCustomerException extends Exception {

    public DuplicateCustomerException(String message) {
        super(message);
    }
}
