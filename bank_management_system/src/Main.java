package bank_management_system.src;
import bank_management_system.src.model.*;
import bank_management_system.src.service.*;

// public class Main {

//     public static void main(String[] args) {

//         // phase 1 test
//         // Customer customer = new Customer(
//         //     1001,
//         //     "Rahul",
//         //     "9876543210",
//         //     "rahul@gmail.com"
//         // );

//         // Account savingsAccount =
//         //     new SavingsAccount(100001, customer);

//         // Account currentAccount =
//         //     new CurrentAccount(100002, customer);

//         // System.out.println("Customer: " + customer.getName());

//         // System.out.println(
//         //     "Savings Account: "
//         //     + savingsAccount.getAccountNumber()
//         // );

//         // System.out.println(
//         //     "Current Account: "
//         //     + currentAccount.getAccountNumber()
//         // );

//         // System.out.println("\n--- Savings Account ---");

//         // savingsAccount.deposit(10000);

//         // System.out.println(
//         //     "Balance: " + savingsAccount.getBalance()
//         // );

//         // savingsAccount.withdraw(2000);

//         // System.out.println(
//         //     "Balance: " + savingsAccount.getBalance()
//         // );
        
        
//         //Phase 2a
        
//         // Bank bank = new Bank();
        
//         // Customer saivenkat = new Customer(1422712, "Sai Venkat", "6301088203", "mutyalasai7@gmail.com");
//         // Customer lakshmi = new Customer(1422762, "Kolli Lakshmi", "8179751782", "kollilakshmi2506@gmail.com");

//         // bank.addCustomer(saivenkat);
//         // bank.addCustomer(lakshmi);

//         // Account account1 = new SavingsAccount(1422712, saivenkat);
//         // Account account2 = new SavingsAccount(1422762, lakshmi);

//         // bank.addAccount(account1);
//         // bank.addAccount(account2);


//         // System.out.println();

//         // // Testing Find Customer 
//         // System.out.println("Testing Find Customer of customerId: 1422762");
//         // Customer foundCustomer = bank.findCustomer(1422762);

//         // if(foundCustomer==null ){
//         //     System.out.println("Customer Not Found!");
//         // }else{
//         //     System.out.println("Customer Name : " + foundCustomer.getName());
//         // }

//         // System.out.println();

//         // // Find Customer details with Account
//         // Account foundAccount = bank.findAccount(1422762);

//         // if(foundAccount==null){
//         //     System.out.println("No account exists");
//         // } else {
//         //     System.out.println("Account Number: "+foundAccount.getAccountNumber());
//         //     System.out.println("Owner: "+foundAccount.getCustomer().getName());
//         //     System.out.println("Balance: "+foundAccount.getBalance());
//         // }
        

//         // Phase 2b
//         Bank bank = new Bank();

//         Customer customer1 = new Customer(
//             1422, 
//             "Lakshmi", 
//             "8179751782", 
//             "kollilakshmi2506@gmail.com");

//         Customer customer2 = new Customer(
//             1423, 
//             "Venkaat", 
//             "6301088203", 
//             "mutyalasai7@gmail.com");
        
//         bank.addCustomer(customer1);
//         bank.addCustomer(customer2);

//         Account account1 = bank.createSavingsAccount(1422); 
//         Account account2 = bank.createSavingsAccount(1423);
        
//         // Phase 3
//         // Account account2 = bank.findAccount(100001);
//         // account2.deposit(5000);
//         // System.out.println("Balance after Deposit: "+ account2.getBalance());
//         // account2.withdraw(300);
//         // System.out.println("Balance after Withdrawl of 300: "+ account2.getBalance());
//         // account2.withdraw(4500);

//         // depositing money with account number

//         System.out.println();
//         bank.depositMoney(100001, 5000);

//         System.out.println();
//         System.out.println("Balances before transfers: ");
//         bank.checkBalance(100001);
//         bank.checkBalance(100002);
        
//         System.out.println();
//         bank.transferMoney(100001, 100002, 2000); 
    
//         System.out.println();
//         System.out.println("Balances after transfers: ");
//         bank.checkBalance(100001);
//         bank.checkBalance(100002);
//     }
// }

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            // =========================
            // Create Customers
            // =========================

            Customer customer1 =
                new Customer(
                    1001,
                    "Rahul",
                    "9876543210",
                    "rahul@gmail.com"
                );

            Customer customer2 =
                new Customer(
                    1002,
                    "Priya",
                    "9123456780",
                    "priya@gmail.com"
                );

            bank.addCustomer(customer1);
            bank.addCustomer(customer2);


            // =========================
            // Create Accounts
            // =========================

            Account rahulAccount =
                bank.createSavingsAccount(1001);

            Account priyaAccount =
                bank.createCurrentAccount(1002);


            // =========================
            // Deposits
            // =========================

            bank.depositMoney(
                rahulAccount.getAccountNumber(),
                10000
            );

            bank.depositMoney(
                priyaAccount.getAccountNumber(),
                5000
            );


            // =========================
            // Withdrawal
            // =========================

            bank.withdrawMoney(
                rahulAccount.getAccountNumber(),
                2000
            );


            // =========================
            // Transfer
            // =========================

            bank.transferMoney(
                rahulAccount.getAccountNumber(),
                priyaAccount.getAccountNumber(),
                3000
            );


            // =========================
            // Final Balance
            // =========================

            bank.checkBalance(
                rahulAccount.getAccountNumber()
            );

            bank.checkBalance(
                priyaAccount.getAccountNumber()
            );

        } catch (Exception e) {

            System.out.println(
                "Banking Error: "
                + e.getMessage()
            );
        }
    }
}