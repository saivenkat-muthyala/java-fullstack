package bank_management_system.src;
import bank_management_system.src.model.*;
import bank_management_system.src.service.*;
import bank_management_system.src.expection.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
            new Scanner(System.in);

        Bank bank =
            new Bank();

        BankService service =
            new BankService(bank);

        while (true) {

            showMenu();

            System.out.print(
                "Enter your choice: "
            );

            int choice =
                scanner.nextInt();

            switch (choice) {

                case 1:
                    addCustomer(
                        scanner,
                        service
                    );
                    break;

                case 2:
                    createSavingsAccount(
                        scanner,
                        service
                    );
                    break;

                case 3:
                    createCurrentAccount(
                        scanner,
                        service
                    );
                    break;

                case 4:
                    deposit(
                        scanner,
                        service
                    );
                    break;

                case 5:
                    withdraw(
                        scanner,
                        service
                    );
                    break;

                case 6:
                    transfer(
                        scanner,
                        service
                    );
                    break;

                case 7:
                    checkBalance(
                        scanner,
                        service
                    );
                    break;

                case 8:
                    transactionHistory(
                        scanner,
                        service
                    );
                    break;

                case 9:
                    closeAccount(
                        scanner,
                        service
                    );
                    break;

                case 10:
                    service.listCustomers();
                    break;

                case 11:
                    service.listAccounts();
                    break;

                case 0:
                    System.out.println(
                        "Thank you for using " +
                        "Bank Management System."
                    );

                    scanner.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice."
                    );
            }
        }
    }

    private static void showMenu() {

        System.out.println();
        System.out.println(
            "========================================"
        );

        System.out.println(
            "       BANK MANAGEMENT SYSTEM"
        );

        System.out.println(
            "========================================"
        );

        System.out.println(
            "1. Add Customer"
        );

        System.out.println(
            "2. Create Savings Account"
        );

        System.out.println(
            "3. Create Current Account"
        );

        System.out.println(
            "4. Deposit Money"
        );

        System.out.println(
            "5. Withdraw Money"
        );

        System.out.println(
            "6. Transfer Money"
        );

        System.out.println(
            "7. Check Balance"
        );

        System.out.println(
            "8. Transaction History"
        );

        System.out.println(
            "9. Close Account"
        );

        System.out.println(
            "10. List Customers"
        );

        System.out.println(
            "11. List Accounts"
        );

        System.out.println(
            "0. Exit"
        );

        System.out.println(
            "========================================"
        );
    }

    private static void addCustomer(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter customer ID: "
        );

        int customerId =
            scanner.nextInt();

        scanner.nextLine();

        System.out.print(
            "Enter name: "
        );

        String name =
            scanner.nextLine();

        System.out.print(
            "Enter mobile number: "
        );

        String mobileNumber =
            scanner.nextLine();

        System.out.print(
            "Enter email: "
        );

        String email =
            scanner.nextLine();

        try {

            service.addCustomer(
                customerId,
                name,
                mobileNumber,
                email
            );

        } catch (DuplicateCustomerException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void createSavingsAccount(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter customer ID: "
        );

        int customerId =
            scanner.nextInt();

        try {

            Account account =
                service.createSavingsAccount(
                    customerId
                );

            System.out.println(
                "Account created successfully."
            );

            System.out.println(
                "Account Number: " +
                account.getAccountNumber()
            );

        } catch (CustomerNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void createCurrentAccount(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter customer ID: "
        );

        int customerId =
            scanner.nextInt();

        try {

            Account account =
                service.createCurrentAccount(
                    customerId
                );

            System.out.println(
                "Account created successfully."
            );

            System.out.println(
                "Account Number: " +
                account.getAccountNumber()
            );

        } catch (CustomerNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void deposit(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter account number: "
        );

        int accountNumber =
            scanner.nextInt();

        System.out.print(
            "Enter amount: "
        );

        double amount =
            scanner.nextDouble();

        try {

            service.deposit(
                accountNumber,
                amount
            );

            System.out.println(
                "Deposit successful."
            );

        } catch (
            AccountNotFoundException |
            InvalidAmountException |
            AccountClosedException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void withdraw(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter account number: "
        );

        int accountNumber =
            scanner.nextInt();

        System.out.print(
            "Enter amount: "
        );

        double amount =
            scanner.nextDouble();

        try {

            service.withdraw(
                accountNumber,
                amount
            );

            System.out.println(
                "Withdrawal successful."
            );

        } catch (
            AccountNotFoundException |
            InvalidAmountException |
            InsufficientBalanceException |
            AccountClosedException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void transfer(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter source account number: "
        );

        int fromAccountNumber =
            scanner.nextInt();

        System.out.print(
            "Enter destination account number: "
        );

        int toAccountNumber =
            scanner.nextInt();

        System.out.print(
            "Enter amount: "
        );

        double amount =
            scanner.nextDouble();

        try {

            service.transfer(
                fromAccountNumber,
                toAccountNumber,
                amount
            );

            System.out.println(
                "Transfer successful."
            );

        } catch (
            AccountNotFoundException |
            InvalidAmountException |
            InsufficientBalanceException |
            AccountClosedException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void checkBalance(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter account number: "
        );

        int accountNumber =
            scanner.nextInt();

        try {

            Account account =
                service.getAccount(
                    accountNumber
                );

            System.out.println();

            System.out.println(
                "Account Number : " +
                account.getAccountNumber()
            );

            System.out.println(
                "Account Holder : " +
                account.getCustomer().getName()
            );

            System.out.println(
                "Balance        : ₹" +
                account.getBalance()
            );

            System.out.println(
                "Status         : " +
                account.getStatus()
            );

        } catch (AccountNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void transactionHistory(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter account number: "
        );

        int accountNumber =
            scanner.nextInt();

        try {

            service.showTransactionHistory(
                accountNumber
            );

        } catch (AccountNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    private static void closeAccount(
            Scanner scanner,
            BankService service) {

        System.out.print(
            "Enter account number: "
        );

        int accountNumber =
            scanner.nextInt();

        try {

            service.closeAccount(
                accountNumber
            );

            System.out.println(
                "Account closed successfully."
            );

        } catch (
            AccountNotFoundException |
            AccountClosedException |
            AccountHasBalanceException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}





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

// public class Main {

//     public static void main(String[] args) {

//         Bank bank = new Bank();

//         try {

//             // =========================
//             // Create Customers
//             // =========================

//             Customer customer1 =
//                 new Customer(
//                     1001,
//                     "Rahul",
//                     "9876543210",
//                     "rahul@gmail.com"
//                 );

//             Customer customer2 =
//                 new Customer(
//                     1002,
//                     "Priya",
//                     "9123456780",
//                     "priya@gmail.com"
//                 );

//             bank.addCustomer(customer1);
//             bank.addCustomer(customer2);


//             // =========================
//             // Create Accounts
//             // =========================

//             Account rahulAccount =
//                 bank.createSavingsAccount(1001);

//             Account priyaAccount =
//                 bank.createCurrentAccount(1002);


//             // =========================
//             // Deposits
//             // =========================

//             bank.depositMoney(
//                 rahulAccount.getAccountNumber(),
//                 10000
//             );

//             bank.depositMoney(
//                 priyaAccount.getAccountNumber(),
//                 5000
//             );


//             // =========================
//             // Withdrawal
//             // =========================

//             bank.withdrawMoney(
//                 rahulAccount.getAccountNumber(),
//                 2000
//             );


//             // =========================
//             // Transfer
//             // =========================

//             bank.transferMoney(
//                 rahulAccount.getAccountNumber(),
//                 priyaAccount.getAccountNumber(),
//                 3000
//             );


//             // =========================
//             // Final Balance
//             // =========================

//             bank.checkBalance(
//                 rahulAccount.getAccountNumber()
//             );

//             bank.checkBalance(
//                 priyaAccount.getAccountNumber()
//             );

//         } catch (Exception e) {

//             System.out.println(
//                 "Banking Error: "
//                 + e.getMessage()
//             );
//         }
//     }
// }

// public class Main {

//     public static void main(String[] args) {

//         Bank bank = new Bank();

//         try {

//             // -------------------------
//             // Create Customers
//             // -------------------------

//             Customer customer1 =
//                 new Customer(
//                     101,
//                     "Sai",
//                     "9876543210",
//                     "sai@gmail.com"
//                 );

//             Customer customer2 =
//                 new Customer(
//                     102,
//                     "Ravi",
//                     "9876543211",
//                     "ravi@gmail.com"
//                 );

//             bank.addCustomer(customer1);
//             bank.addCustomer(customer2);

//             // -------------------------
//             // Create Accounts
//             // -------------------------

//             Account savings =
//                 bank.createSavingsAccount(101);

//             Account current =
//                 bank.createCurrentAccount(102);

//             // -------------------------
//             // Deposit
//             // -------------------------

//             bank.depositMoney(
//                 savings.getAccountNumber(),
//                 5000
//             );

//             bank.depositMoney(
//                 current.getAccountNumber(),
//                 10000
//             );

//             // -------------------------
//             // Check Balances
//             // -------------------------

//             System.out.println(
//                 "\nSavings Balance: ₹" +
//                 savings.getBalance()
//             );

//             System.out.println(
//                 "Current Balance: ₹" +
//                 current.getBalance()
//             );

//             // -------------------------
//             // Transfer
//             // -------------------------

//             bank.transferMoney(
//                 savings.getAccountNumber(),
//                 current.getAccountNumber(),
//                 1000
//             );

//             // -------------------------
//             // List Accounts
//             // -------------------------

//             bank.listAccounts();

//         } catch (Exception e) {

//             System.out.println(
//                 "Error: " + e.getMessage()
//             );
//         }
//     }
// }