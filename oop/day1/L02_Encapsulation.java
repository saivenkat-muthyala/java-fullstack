package oop.day1;

public class L02_Encapsulation {

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();

        System.out.println("Balance of B1 at start: " + b1.getBalance());

        b1.deposit(2000);

        System.out.println("Balance of B1 after: " + b1.getBalance());
    }
    
}

class BankAccount {
    private double balance; // Hidden data
    
    public double getBalance(){  // getter
        return balance;
    }

    public void deposit(double amount){   // setter
        if(amount>0){
            balance+=amount;
        }
    }
}

