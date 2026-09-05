package bank_management_system.src.model;

public class Transaction {
    
    private int transactionId;
    private String type;
    private double amount;
    private double balanceAfterTransaction;

    public Transaction(int transactionId, String type, double amount, double balanceAfterTransaction){
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public int getTransactionId(){
        return transactionId;
    }

    public String getType(){
        return type;
    }

    public double getAmount(){
        return amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

}
