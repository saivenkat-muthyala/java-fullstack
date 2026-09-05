package bank_management_system.src.model;

public class Customer {

    // private variables -> encapsulation
    private int customerId;
    private String name;
    private String mobileNumber;
    private String email;

    public Customer(int customerId, String name, String mobileNumber, String email){
        this.customerId=customerId;
        this.name=name;
        this.mobileNumber=mobileNumber;
        this.email=email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}
