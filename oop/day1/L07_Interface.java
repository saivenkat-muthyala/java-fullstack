package oop.day1;

public class L07_Interface {
    public static void main(String[] args) {
        
    }
}

interface PaymentProcessor {
    void processPayment(double amount); // Implicitly abstract and public
}

// Implementation class 1
class CreditCardPayment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// Implementation class 2
class UPIPayment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing UPI digital payment of $" + amount);
    }
}